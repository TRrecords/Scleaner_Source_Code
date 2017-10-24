Type=Service
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim rv As RemoteViews
	Private kvsdata,alist As KeyValueStore
	Private cts As CustomToast
	Private mcl As MaterialColors
End Sub

Sub Service_Create
	rv= ConfigureHomeWidget("wv","rv",0,"SBoost",True)
	kvsdata.Initialize(File.DirInternal,"data_data")
	alist.Initialize(File.DirInternal,"adata_data")
	cts.Initialize
	Private ostat As OSStats
	Private mos As MSOS
	ostat.Initialize(400, 50, Me, "Stats")
	ostat.StartStats
	rv.SetVisible("b1",True)
	rv.SetVisible("p1",True)
	rv.SetVisible("pb1",False)
	rv.SetVisible("l2",False)
	rv.SetTextColor("l2",mcl.md_amber_400)
End Sub

Sub Service_Start (StartingIntent As Intent)
	If rv.HandleWidgetEvents(StartingIntent) Then Return

End Sub

Sub rv_requestUpdate
	rv.UpdateWidget
End Sub

Sub rv_Disabled
	StopService("")
End Sub

Sub Service_Destroy

End Sub

Sub rv_restart
	Dim icon As BitmapDrawable
	Dim icon2 As Bitmap
	Dim pac As PackageManager
	rv.SetVisible("pb1",False)
	rv.SetVisible("l2",False)
	rv.SetVisible("b1",True)
	Dim sum As Int=0
	For Each g As String In alist.ListKeys
		Log(FormatFileSize(alist.Get(g)))
		sum=sum+alist.Get(g)
		icon=pac.GetApplicationIcon(g)
	Next
	'cts.ShowBitmap(FormatFileSize(sum)&" bereinigt..",5,Gravity.BOTTOM,0,0,LoadBitmap(File.DirAssets,"ic_sms_failed_white_36dp.png"))
End Sub

Sub b1_Click
	CallSubDelayed(Starter,"wid_start")
	rv.SetVisible("pb1",True)
	rv.SetVisible("l2",True)
	rv.SetVisible("b1",False)
	rv_requestUpdate
End Sub

Sub prog_update
	Dim cc,c As Int
	c=kvsdata.Get("c")
	cc=kvsdata.Get("to")
	'rv.SetProgress("pb1",maxs)
	rv.SetText("l2",c&CRLF&"/"&cc)
End Sub

Sub stats_Update(CPUEfficiency() As Float, RAMUsage As Float)
	'rv.SetProgress("pb1",RAMUsage)
	rv.SetText("b1",FormatFileSize(RAMUsage*1024*1024*10))
	rv_requestUpdate
End Sub


Sub rv_clean
	CallSubDelayed(Starter,"clean_start")
End Sub


Sub FormatFileSize(Bytes As Float) As String
	Private Unit() As String = Array As String(" Byte", " KB", " MB", " GB", " TB", " PB", " EB", " ZB", " YB")
	If Bytes = 0 Then
		Return "0 Bytes"
	Else
		Private Po, Si As Double
		Private I As Int
		Bytes = Abs(Bytes)
		I = Floor(Logarithm(Bytes, 1024))
		Po = Power(1024, I)
		Si = Bytes / Po
		Return NumberFormat(Si, 1, 2) & Unit(I)
	End If
End Sub
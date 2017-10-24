Type=Service
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private cb As CacheCleaner
	Dim t2,t3 As Timer
	Private name,apath,l,Types(1),packName As String
	Dim app() As Object
	Dim counter As Int
	Private cts As CustomToast
	Dim piclist As List
	Dim obj As List
	Dim date,time As String
	Dim dir As String=File.DirInternal&"/Bdata"
	Private kvst,kvsdata,alist,dbase,abase As KeyValueStore
	
	
End Sub

Sub Service_Create
	
	DateTime.TimeFormat="HH:mm"
	DateTime.DateFormat="dd.MM.yyy"
	date=DateTime.Date(DateTime.Now)
	time=DateTime.Time(DateTime.Now)
	kvst.Initialize(File.DirInternal,"data_time")
	kvsdata.Initialize(File.DirInternal,"data_data")
	alist.Initialize(File.DirInternal,"adata_data")
	dbase.Initialize(File.DirInternal,"dbase_data")
	abase.Initialize(File.DirInternal,"abase_data")
	
	piclist.Initialize
	obj.Initialize
	cb.initialize("cb")
	cts.Initialize
	counter=0
	t2.Initialize("t2",1000)
	t3.Initialize("t3",1000)
	t3.Enabled=False
	If Not(File.IsDirectory(File.DirInternal,"Bdata")) Then
		File.MakeDir(File.DirInternal,"Bdata/temp")
		File.WriteList(dir,"clist.txt",obj)
	End If
End Sub

Sub Service_Start (StartingIntent As Intent)
	
End Sub

Sub Service_Destroy
	t2.Enabled=False
End Sub

Sub rv_on
	StartService(info)
End Sub
Sub rv_off
	StopService(info)
End Sub
Sub remote_start
	cb.ScanCache
	kvst.DeleteAll
	
End Sub
Sub wid_start
	cb.ScanCache
End Sub

Sub cb_OnScanStarted
	Log("Started")
	CallSub(info,"c_start")
End Sub


Sub cb_onScanProgress(Current As Int , Total As Int)
	kvsdata.Put("to",Total)
	kvsdata.Put("c",Current)
	CallSub(Widget,"prog_update")
	CallSubDelayed (Main,"pb_update")
	CallSub(info,"c_update")
	Log("Scan: "&Current&" /"&Total)
	
End Sub

Sub cb_onScanCompleted(AppsList As Object)
	Dim totalsize As Long = 0
	Dim pm As PackageManager
	Private icon As BitmapDrawable
	
	piclist.Clear
	obj.Clear
	alist.DeleteAll
	Try
		Dim lu As List = AppsList
'		If lu.Size=0 Then
'			Log("nothing to show")
'			
'			Return
'		End If
		For n = 0 To lu.Size-1
			app= lu.Get(n)
			If app(1) = "com.android.systemui"  Then  Continue 'com.android.systemui This Pakage Have No Icon In Some Android 5
			icon = pm.GetApplicationIcon(app(1))
			totalsize = totalsize+app(2)
			kvst.PutBitmap(app(1),icon.Bitmap)
			alist.Put(app(1),totalsize)
			obj.Add(app(1))
			kvsdata.Put("cs",FormatFileSize(totalsize))
			kvsdata.Put(totalsize,totalsize)
		Next
		
	Catch
		Log(LastException.Message)
	End Try
	If lu.size>0 Then
		CallSub(Widget,"rv_clean")
		CallSub(Main,"dp_off")
		Else 
			CallSub(Widget,"rv_restart")
			CallSub(Widget,"rv_restart")
		CallSub(Main,"total_off")
	End If
	
End Sub

Sub clean_start
	cb.CleanCache
	CallSub(info,"c_clean")
	Log("start")
End Sub

Sub cb_onCleanStarted
	CallSub(Widget,"rv_restart")
	Log("CleanStarted")
End Sub

Sub cb_onCleanCompleted(CacheSize As Long)
	CallSub(Main,"dp_clear")
	CallSub(info,"c_ready")
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



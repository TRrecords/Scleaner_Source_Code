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
	Private notify As Notification
	Private kvsdata As KeyValueStore
	Private alist As KeyValueStore
End Sub

Sub Service_Create
	kvsdata.Initialize(File.DirInternal,"data_data")
	alist.Initialize(File.DirInternal,"adata_data")
	notify.Initialize
	notify.Icon="icon"
	notify.Number=1
	notify.AutoCancel=True
	notify.Light=False
	notify.Sound=False
	notify.Vibrate=False
End Sub

Sub Service_Start (StartingIntent As Intent)
	notify.SetInfo("Cleaner Service:","der Cleaner Service wurde erfolgreich gestartet",Main)
	notify.Notify(1)
End Sub

Sub Service_Destroy
	notify.Cancel(1)
End Sub


Sub c_start
	notify.SetInfo("Suche gestartet:","durchsuche Apps..",Main)
	notify.Notify(1)
End Sub

Sub c_update
	Dim cc As Int
	cc=kvsdata.Get("c")
	notify.SetInfo(cc&"durchsucht..","durchsuche nach Cache daten..",Main)
	notify.Notify(1)
End Sub

Sub c_clean
	notify.SetInfo("löche cache daten:","einen Moment bitte..",Main)
	notify.Notify(1)
End Sub

Sub c_ready
	notify.SetInfo("Fertig!",alist.ListKeys.Size&" Apps mit bereinigt!",Main)
	notify.Notify(1)
End Sub
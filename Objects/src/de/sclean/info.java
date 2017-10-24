package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class info extends  android.app.Service{
	public static class info_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, info.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static info mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return info.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "de.sclean", "de.sclean.info");
            if (BA.isShellModeRuntimeCheck(processBA)) {
                processBA.raiseEvent2(null, true, "SHELL", false);
		    }
            try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            processBA.loadHtSubs(this.getClass());
            ServiceHelper.init();
        }
        _service = new ServiceHelper(this);
        processBA.service = this;
        
        if (BA.isShellModeRuntimeCheck(processBA)) {
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.info", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (info) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (false) {
			ServiceHelper.StarterHelper.runWaitForLayouts();
		}
    }
		@Override
	public void onStart(android.content.Intent intent, int startId) {
		onStartCommand(intent, 0, 0);
    }
    @Override
    public int onStartCommand(final android.content.Intent intent, int flags, int startId) {
    	if (ServiceHelper.StarterHelper.onStartCommand(processBA, new Runnable() {
            public void run() {
                handleStart(intent);
            }}))
			;
		else {
			ServiceHelper.StarterHelper.addWaitForLayout (new Runnable() {
				public void run() {
                    processBA.setActivityPaused(false);
                    BA.LogInfo("** Service (info) Create **");
                    processBA.raiseEvent(null, "service_create");
					handleStart(intent);
                    ServiceHelper.StarterHelper.removeWaitForLayout();
				}
			});
		}
        processBA.runHook("onstartcommand", this, new Object[] {intent, flags, startId});
		return android.app.Service.START_NOT_STICKY;
    }
    public void onTaskRemoved(android.content.Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (false)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (info) Start **");
    	java.lang.reflect.Method startEvent = processBA.htSubs.get("service_start");
    	if (startEvent != null) {
    		if (startEvent.getParameterTypes().length > 0) {
    			anywheresoftware.b4a.objects.IntentWrapper iw = new anywheresoftware.b4a.objects.IntentWrapper();
    			if (intent != null) {
    				if (intent.hasExtra("b4a_internal_intent"))
    					iw.setObject((android.content.Intent) intent.getParcelableExtra("b4a_internal_intent"));
    				else
    					iw.setObject(intent);
    			}
    			processBA.raiseEvent(null, "service_start", iw);
    		}
    		else {
    			processBA.raiseEvent(null, "service_start");
    		}
    	}
    }
	
	@Override
	public void onDestroy() {
        super.onDestroy();
        BA.LogInfo("** Service (info) Destroy **");
		processBA.raiseEvent(null, "service_destroy");
        processBA.service = null;
		mostCurrent = null;
		processBA.setActivityPaused(true);
        processBA.runHook("ondestroy", this, null);
	}

@Override
	public android.os.IBinder onBind(android.content.Intent intent) {
		return null;
	}public anywheresoftware.b4a.keywords.Common __c = null;
public static anywheresoftware.b4a.objects.NotificationWrapper _notify = null;
public static de.sclean.keyvaluestore _kvsdata = null;
public static de.sclean.keyvaluestore _alist = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public static String  _c_clean() throws Exception{
 //BA.debugLineNum = 48;BA.debugLine="Sub c_clean";
 //BA.debugLineNum = 49;BA.debugLine="notify.SetInfo(\"löche cache daten:\",\"einen Moment";
_notify.SetInfo(processBA,"löche cache daten:","einen Moment bitte..",(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 50;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _c_ready() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub c_ready";
 //BA.debugLineNum = 54;BA.debugLine="notify.SetInfo(\"Fertig!\",alist.ListKeys.Size&\" Ap";
_notify.SetInfo(processBA,"Fertig!",BA.NumberToString(_alist._listkeys().getSize())+" Apps mit bereinigt!",(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 55;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
 //BA.debugLineNum = 56;BA.debugLine="End Sub";
return "";
}
public static String  _c_start() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub c_start";
 //BA.debugLineNum = 37;BA.debugLine="notify.SetInfo(\"Suche gestartet:\",\"durchsuche App";
_notify.SetInfo(processBA,"Suche gestartet:","durchsuche Apps..",(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 38;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
 //BA.debugLineNum = 39;BA.debugLine="End Sub";
return "";
}
public static String  _c_update() throws Exception{
int _cc = 0;
 //BA.debugLineNum = 41;BA.debugLine="Sub c_update";
 //BA.debugLineNum = 42;BA.debugLine="Dim cc As Int";
_cc = 0;
 //BA.debugLineNum = 43;BA.debugLine="cc=kvsdata.Get(\"c\")";
_cc = (int)(BA.ObjectToNumber(_kvsdata._get("c")));
 //BA.debugLineNum = 44;BA.debugLine="notify.SetInfo(cc&\"durchsucht..\",\"durchsuche nach";
_notify.SetInfo(processBA,BA.NumberToString(_cc)+"durchsucht..","durchsuche nach Cache daten..",(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 45;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Private notify As Notification";
_notify = new anywheresoftware.b4a.objects.NotificationWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private kvsdata As KeyValueStore";
_kvsdata = new de.sclean.keyvaluestore();
 //BA.debugLineNum = 11;BA.debugLine="Private alist As KeyValueStore";
_alist = new de.sclean.keyvaluestore();
 //BA.debugLineNum = 12;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 14;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 15;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
_kvsdata._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
 //BA.debugLineNum = 16;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
_alist._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
 //BA.debugLineNum = 17;BA.debugLine="notify.Initialize";
_notify.Initialize();
 //BA.debugLineNum = 18;BA.debugLine="notify.Icon=\"icon\"";
_notify.setIcon("icon");
 //BA.debugLineNum = 19;BA.debugLine="notify.Number=1";
_notify.setNumber((int) (1));
 //BA.debugLineNum = 20;BA.debugLine="notify.AutoCancel=True";
_notify.setAutoCancel(anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 21;BA.debugLine="notify.Light=False";
_notify.setLight(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 22;BA.debugLine="notify.Sound=False";
_notify.setSound(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 23;BA.debugLine="notify.Vibrate=False";
_notify.setVibrate(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 24;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 32;BA.debugLine="notify.Cancel(1)";
_notify.Cancel((int) (1));
 //BA.debugLineNum = 33;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 26;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 27;BA.debugLine="notify.SetInfo(\"Cleaner Service:\",\"der Cleaner Se";
_notify.SetInfo(processBA,"Cleaner Service:","der Cleaner Service wurde erfolgreich gestartet",(Object)(mostCurrent._main.getObject()));
 //BA.debugLineNum = 28;BA.debugLine="notify.Notify(1)";
_notify.Notify((int) (1));
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
}

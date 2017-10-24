package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class widget extends  android.app.Service{
	public static class widget_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, widget.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static widget mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return widget.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "de.sclean", "de.sclean.widget");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.widget", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!false && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (widget) Create ***");
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
                    BA.LogInfo("** Service (widget) Create **");
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
    	BA.LogInfo("** Service (widget) Start **");
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
        BA.LogInfo("** Service (widget) Destroy **");
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
public static anywheresoftware.b4a.objects.RemoteViewsWrapper _rv = null;
public static de.sclean.keyvaluestore _kvsdata = null;
public static de.sclean.keyvaluestore _alist = null;
public static com.rootsoft.customtoast.CustomToast _cts = null;
public static com.tchart.materialcolors.MaterialColors _mcl = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public de.sclean.info _info = null;
public static String  _b1_click() throws Exception{
 //BA.debugLineNum = 64;BA.debugLine="Sub b1_Click";
 //BA.debugLineNum = 65;BA.debugLine="CallSubDelayed(Starter,\"wid_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"wid_start");
 //BA.debugLineNum = 66;BA.debugLine="rv.SetVisible(\"pb1\",True)";
_rv.SetVisible(processBA,"pb1",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 67;BA.debugLine="rv.SetVisible(\"l2\",True)";
_rv.SetVisible(processBA,"l2",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 68;BA.debugLine="rv.SetVisible(\"b1\",False)";
_rv.SetVisible(processBA,"b1",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 69;BA.debugLine="rv_requestUpdate";
_rv_requestupdate();
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
public static String  _formatfilesize(float _bytes) throws Exception{
String[] _unit = null;
double _po = 0;
double _si = 0;
int _i = 0;
 //BA.debugLineNum = 92;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
 //BA.debugLineNum = 93;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
_unit = new String[]{" Byte"," KB"," MB"," GB"," TB"," PB"," EB"," ZB"," YB"};
 //BA.debugLineNum = 94;BA.debugLine="If Bytes = 0 Then";
if (_bytes==0) { 
 //BA.debugLineNum = 95;BA.debugLine="Return \"0 Bytes\"";
if (true) return "0 Bytes";
 }else {
 //BA.debugLineNum = 97;BA.debugLine="Private Po, Si As Double";
_po = 0;
_si = 0;
 //BA.debugLineNum = 98;BA.debugLine="Private I As Int";
_i = 0;
 //BA.debugLineNum = 99;BA.debugLine="Bytes = Abs(Bytes)";
_bytes = (float) (anywheresoftware.b4a.keywords.Common.Abs(_bytes));
 //BA.debugLineNum = 100;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
_i = (int) (anywheresoftware.b4a.keywords.Common.Floor(anywheresoftware.b4a.keywords.Common.Logarithm(_bytes,1024)));
 //BA.debugLineNum = 101;BA.debugLine="Po = Power(1024, I)";
_po = anywheresoftware.b4a.keywords.Common.Power(1024,_i);
 //BA.debugLineNum = 102;BA.debugLine="Si = Bytes / Po";
_si = _bytes/(double)_po;
 //BA.debugLineNum = 103;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_si,(int) (1),(int) (2))+_unit[_i];
 };
 //BA.debugLineNum = 105;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim rv As RemoteViews";
_rv = new anywheresoftware.b4a.objects.RemoteViewsWrapper();
 //BA.debugLineNum = 10;BA.debugLine="Private kvsdata,alist As KeyValueStore";
_kvsdata = new de.sclean.keyvaluestore();
_alist = new de.sclean.keyvaluestore();
 //BA.debugLineNum = 11;BA.debugLine="Private cts As CustomToast";
_cts = new com.rootsoft.customtoast.CustomToast();
 //BA.debugLineNum = 12;BA.debugLine="Private mcl As MaterialColors";
_mcl = new com.tchart.materialcolors.MaterialColors();
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return "";
}
public static String  _prog_update() throws Exception{
int _cc = 0;
int _c = 0;
 //BA.debugLineNum = 72;BA.debugLine="Sub prog_update";
 //BA.debugLineNum = 73;BA.debugLine="Dim cc,c As Int";
_cc = 0;
_c = 0;
 //BA.debugLineNum = 74;BA.debugLine="c=kvsdata.Get(\"c\")";
_c = (int)(BA.ObjectToNumber(_kvsdata._get("c")));
 //BA.debugLineNum = 75;BA.debugLine="cc=kvsdata.Get(\"to\")";
_cc = (int)(BA.ObjectToNumber(_kvsdata._get("to")));
 //BA.debugLineNum = 77;BA.debugLine="rv.SetText(\"l2\",c&CRLF&\"/\"&cc)";
_rv.SetText(processBA,"l2",BA.ObjectToCharSequence(BA.NumberToString(_c)+anywheresoftware.b4a.keywords.Common.CRLF+"/"+BA.NumberToString(_cc)));
 //BA.debugLineNum = 78;BA.debugLine="End Sub";
return "";
}
public static String  _rv_clean() throws Exception{
 //BA.debugLineNum = 87;BA.debugLine="Sub rv_clean";
 //BA.debugLineNum = 88;BA.debugLine="CallSubDelayed(Starter,\"clean_start\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._starter.getObject()),"clean_start");
 //BA.debugLineNum = 89;BA.debugLine="End Sub";
return "";
}
public static String  _rv_disabled() throws Exception{
 //BA.debugLineNum = 40;BA.debugLine="Sub rv_Disabled";
 //BA.debugLineNum = 41;BA.debugLine="StopService(\"\")";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(""));
 //BA.debugLineNum = 42;BA.debugLine="End Sub";
return "";
}
public static String  _rv_requestupdate() throws Exception{
 //BA.debugLineNum = 36;BA.debugLine="Sub rv_requestUpdate";
 //BA.debugLineNum = 37;BA.debugLine="rv.UpdateWidget";
_rv.UpdateWidget(processBA);
 //BA.debugLineNum = 38;BA.debugLine="End Sub";
return "";
}
public static String  _rv_restart() throws Exception{
anywheresoftware.b4a.objects.drawable.BitmapDrawable _icon = null;
anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper _icon2 = null;
anywheresoftware.b4a.phone.PackageManagerWrapper _pac = null;
int _sum = 0;
String _g = "";
 //BA.debugLineNum = 48;BA.debugLine="Sub rv_restart";
 //BA.debugLineNum = 49;BA.debugLine="Dim icon As BitmapDrawable";
_icon = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 50;BA.debugLine="Dim icon2 As Bitmap";
_icon2 = new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper();
 //BA.debugLineNum = 51;BA.debugLine="Dim pac As PackageManager";
_pac = new anywheresoftware.b4a.phone.PackageManagerWrapper();
 //BA.debugLineNum = 52;BA.debugLine="rv.SetVisible(\"pb1\",False)";
_rv.SetVisible(processBA,"pb1",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 53;BA.debugLine="rv.SetVisible(\"l2\",False)";
_rv.SetVisible(processBA,"l2",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 54;BA.debugLine="rv.SetVisible(\"b1\",True)";
_rv.SetVisible(processBA,"b1",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 55;BA.debugLine="Dim sum As Int=0";
_sum = (int) (0);
 //BA.debugLineNum = 56;BA.debugLine="For Each g As String In alist.ListKeys";
{
final anywheresoftware.b4a.BA.IterableList group8 = _alist._listkeys();
final int groupLen8 = group8.getSize()
;int index8 = 0;
;
for (; index8 < groupLen8;index8++){
_g = BA.ObjectToString(group8.Get(index8));
 //BA.debugLineNum = 57;BA.debugLine="Log(FormatFileSize(alist.Get(g)))";
anywheresoftware.b4a.keywords.Common.Log(_formatfilesize((float)(BA.ObjectToNumber(_alist._get(_g)))));
 //BA.debugLineNum = 58;BA.debugLine="sum=sum+alist.Get(g)";
_sum = (int) (_sum+(double)(BA.ObjectToNumber(_alist._get(_g))));
 //BA.debugLineNum = 59;BA.debugLine="icon=pac.GetApplicationIcon(g)";
_icon.setObject((android.graphics.drawable.BitmapDrawable)(_pac.GetApplicationIcon(_g)));
 }
};
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
b4a.example.osstats _ostat = null;
com.maximussoft.msos.MSOS _mos = null;
 //BA.debugLineNum = 15;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 16;BA.debugLine="rv= ConfigureHomeWidget(\"wv\",\"rv\",0,\"SBoost\",True";
_rv = anywheresoftware.b4a.objects.RemoteViewsWrapper.createRemoteViews(processBA, R.layout.widget_layout, "wv","rv");
 //BA.debugLineNum = 17;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
_kvsdata._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
 //BA.debugLineNum = 18;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
_alist._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
 //BA.debugLineNum = 19;BA.debugLine="cts.Initialize";
_cts.Initialize(processBA);
 //BA.debugLineNum = 20;BA.debugLine="Private ostat As OSStats";
_ostat = new b4a.example.osstats();
 //BA.debugLineNum = 21;BA.debugLine="Private mos As MSOS";
_mos = new com.maximussoft.msos.MSOS();
 //BA.debugLineNum = 22;BA.debugLine="ostat.Initialize(400, 50, Me, \"Stats\")";
_ostat._initialize(processBA,(int) (400),(int) (50),widget.getObject(),"Stats");
 //BA.debugLineNum = 23;BA.debugLine="ostat.StartStats";
_ostat._startstats();
 //BA.debugLineNum = 24;BA.debugLine="rv.SetVisible(\"b1\",True)";
_rv.SetVisible(processBA,"b1",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 25;BA.debugLine="rv.SetVisible(\"p1\",True)";
_rv.SetVisible(processBA,"p1",anywheresoftware.b4a.keywords.Common.True);
 //BA.debugLineNum = 26;BA.debugLine="rv.SetVisible(\"pb1\",False)";
_rv.SetVisible(processBA,"pb1",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 27;BA.debugLine="rv.SetVisible(\"l2\",False)";
_rv.SetVisible(processBA,"l2",anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 28;BA.debugLine="rv.SetTextColor(\"l2\",mcl.md_amber_400)";
_rv.SetTextColor(processBA,"l2",_mcl.getmd_amber_400());
 //BA.debugLineNum = 29;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 44;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 46;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 31;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 32;BA.debugLine="If rv.HandleWidgetEvents(StartingIntent) Then Ret";
if (_rv.HandleWidgetEvents(processBA,(android.content.Intent)(_startingintent.getObject()))) { 
if (true) return "";};
 //BA.debugLineNum = 34;BA.debugLine="End Sub";
return "";
}
public static String  _stats_update(float[] _cpuefficiency,float _ramusage) throws Exception{
 //BA.debugLineNum = 80;BA.debugLine="Sub stats_Update(CPUEfficiency() As Float, RAMUsag";
 //BA.debugLineNum = 82;BA.debugLine="rv.SetText(\"b1\",FormatFileSize(RAMUsage*1024*1024";
_rv.SetText(processBA,"b1",BA.ObjectToCharSequence(_formatfilesize((float) (_ramusage*1024*1024*10))));
 //BA.debugLineNum = 83;BA.debugLine="rv_requestUpdate";
_rv_requestupdate();
 //BA.debugLineNum = 84;BA.debugLine="End Sub";
return "";
}
}

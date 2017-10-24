package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.objects.ServiceHelper;
import anywheresoftware.b4a.debug.*;

public class starter extends  android.app.Service{
	public static class starter_BR extends android.content.BroadcastReceiver {

		@Override
		public void onReceive(android.content.Context context, android.content.Intent intent) {
			android.content.Intent in = new android.content.Intent(context, starter.class);
			if (intent != null)
				in.putExtra("b4a_internal_intent", intent);
			context.startService(in);
		}

	}
    static starter mostCurrent;
	public static BA processBA;
    private ServiceHelper _service;
    public static Class<?> getObject() {
		return starter.class;
	}
	@Override
	public void onCreate() {
        super.onCreate();
        mostCurrent = this;
        if (processBA == null) {
		    processBA = new BA(this, null, null, "de.sclean", "de.sclean.starter");
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
			processBA.raiseEvent2(null, true, "CREATE", true, "de.sclean.starter", processBA, _service, anywheresoftware.b4a.keywords.Common.Density);
		}
        if (!true && ServiceHelper.StarterHelper.startFromServiceCreate(processBA, false) == false) {
				
		}
		else {
            processBA.setActivityPaused(false);
            BA.LogInfo("*** Service (starter) Create ***");
            processBA.raiseEvent(null, "service_create");
        }
        processBA.runHook("oncreate", this, null);
        if (true) {
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
                    BA.LogInfo("** Service (starter) Create **");
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
        if (true)
            processBA.raiseEvent(null, "service_taskremoved");
            
    }
    private void handleStart(android.content.Intent intent) {
    	BA.LogInfo("** Service (starter) Start **");
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
        BA.LogInfo("** Service (starter) Destroy **");
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
public static anywheresoftware.b4a.cachecleaner.CacheCleaner _cb = null;
public static anywheresoftware.b4a.objects.Timer _t2 = null;
public static anywheresoftware.b4a.objects.Timer _t3 = null;
public static String _name = "";
public static String _apath = "";
public static String _l = "";
public static String[] _types = null;
public static String _packname = "";
public static Object[] _app = null;
public static int _counter = 0;
public static com.rootsoft.customtoast.CustomToast _cts = null;
public static anywheresoftware.b4a.objects.collections.List _piclist = null;
public static anywheresoftware.b4a.objects.collections.List _obj = null;
public static String _date = "";
public static String _time = "";
public static String _dir = "";
public static de.sclean.keyvaluestore _kvst = null;
public static de.sclean.keyvaluestore _kvsdata = null;
public static de.sclean.keyvaluestore _alist = null;
public static de.sclean.keyvaluestore _dbase = null;
public static de.sclean.keyvaluestore _abase = null;
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.animator _animator = null;
public de.sclean.info _info = null;
public static String  _cb_oncleancompleted(long _cachesize) throws Exception{
 //BA.debugLineNum = 140;BA.debugLine="Sub cb_onCleanCompleted(CacheSize As Long)";
 //BA.debugLineNum = 141;BA.debugLine="CallSub(Main,\"dp_clear\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._main.getObject()),"dp_clear");
 //BA.debugLineNum = 142;BA.debugLine="CallSub(info,\"c_ready\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._info.getObject()),"c_ready");
 //BA.debugLineNum = 143;BA.debugLine="End Sub";
return "";
}
public static String  _cb_oncleanstarted() throws Exception{
 //BA.debugLineNum = 135;BA.debugLine="Sub cb_onCleanStarted";
 //BA.debugLineNum = 136;BA.debugLine="CallSub(Widget,\"rv_restart\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._widget.getObject()),"rv_restart");
 //BA.debugLineNum = 137;BA.debugLine="Log(\"CleanStarted\")";
anywheresoftware.b4a.keywords.Common.Log("CleanStarted");
 //BA.debugLineNum = 138;BA.debugLine="End Sub";
return "";
}
public static String  _cb_onscancompleted(Object _appslist) throws Exception{
long _totalsize = 0L;
anywheresoftware.b4a.phone.PackageManagerWrapper _pm = null;
anywheresoftware.b4a.objects.drawable.BitmapDrawable _icon = null;
anywheresoftware.b4a.objects.collections.List _lu = null;
int _n = 0;
 //BA.debugLineNum = 88;BA.debugLine="Sub cb_onScanCompleted(AppsList As Object)";
 //BA.debugLineNum = 89;BA.debugLine="Dim totalsize As Long = 0";
_totalsize = (long) (0);
 //BA.debugLineNum = 90;BA.debugLine="Dim pm As PackageManager";
_pm = new anywheresoftware.b4a.phone.PackageManagerWrapper();
 //BA.debugLineNum = 91;BA.debugLine="Private icon As BitmapDrawable";
_icon = new anywheresoftware.b4a.objects.drawable.BitmapDrawable();
 //BA.debugLineNum = 93;BA.debugLine="piclist.Clear";
_piclist.Clear();
 //BA.debugLineNum = 94;BA.debugLine="obj.Clear";
_obj.Clear();
 //BA.debugLineNum = 95;BA.debugLine="alist.DeleteAll";
_alist._deleteall();
 //BA.debugLineNum = 96;BA.debugLine="Try";
try { //BA.debugLineNum = 97;BA.debugLine="Dim lu As List = AppsList";
_lu = new anywheresoftware.b4a.objects.collections.List();
_lu.setObject((java.util.List)(_appslist));
 //BA.debugLineNum = 103;BA.debugLine="For n = 0 To lu.Size-1";
{
final int step9 = 1;
final int limit9 = (int) (_lu.getSize()-1);
_n = (int) (0) ;
for (;(step9 > 0 && _n <= limit9) || (step9 < 0 && _n >= limit9) ;_n = ((int)(0 + _n + step9))  ) {
 //BA.debugLineNum = 104;BA.debugLine="app= lu.Get(n)";
_app = (Object[])(_lu.Get(_n));
 //BA.debugLineNum = 105;BA.debugLine="If app(1) = \"com.android.systemui\"  Then  Conti";
if ((_app[(int) (1)]).equals((Object)("com.android.systemui"))) { 
if (true) continue;};
 //BA.debugLineNum = 106;BA.debugLine="icon = pm.GetApplicationIcon(app(1))";
_icon.setObject((android.graphics.drawable.BitmapDrawable)(_pm.GetApplicationIcon(BA.ObjectToString(_app[(int) (1)]))));
 //BA.debugLineNum = 107;BA.debugLine="totalsize = totalsize+app(2)";
_totalsize = (long) (_totalsize+(double)(BA.ObjectToNumber(_app[(int) (2)])));
 //BA.debugLineNum = 108;BA.debugLine="kvst.PutBitmap(app(1),icon.Bitmap)";
_kvst._putbitmap(BA.ObjectToString(_app[(int) (1)]),(anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.drawable.CanvasWrapper.BitmapWrapper(), (android.graphics.Bitmap)(_icon.getBitmap())));
 //BA.debugLineNum = 109;BA.debugLine="alist.Put(app(1),totalsize)";
_alist._put(BA.ObjectToString(_app[(int) (1)]),(Object)(_totalsize));
 //BA.debugLineNum = 110;BA.debugLine="obj.Add(app(1))";
_obj.Add(_app[(int) (1)]);
 //BA.debugLineNum = 111;BA.debugLine="kvsdata.Put(\"cs\",FormatFileSize(totalsize))";
_kvsdata._put("cs",(Object)(_formatfilesize((float) (_totalsize))));
 //BA.debugLineNum = 112;BA.debugLine="kvsdata.Put(totalsize,totalsize)";
_kvsdata._put(BA.NumberToString(_totalsize),(Object)(_totalsize));
 }
};
 } 
       catch (Exception e21) {
			processBA.setLastException(e21); //BA.debugLineNum = 116;BA.debugLine="Log(LastException.Message)";
anywheresoftware.b4a.keywords.Common.Log(anywheresoftware.b4a.keywords.Common.LastException(processBA).getMessage());
 };
 //BA.debugLineNum = 118;BA.debugLine="If lu.size>0 Then";
if (_lu.getSize()>0) { 
 //BA.debugLineNum = 119;BA.debugLine="CallSub(Widget,\"rv_clean\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._widget.getObject()),"rv_clean");
 //BA.debugLineNum = 120;BA.debugLine="CallSub(Main,\"dp_off\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._main.getObject()),"dp_off");
 }else {
 //BA.debugLineNum = 122;BA.debugLine="CallSub(Widget,\"rv_restart\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._widget.getObject()),"rv_restart");
 //BA.debugLineNum = 123;BA.debugLine="CallSub(Widget,\"rv_restart\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._widget.getObject()),"rv_restart");
 //BA.debugLineNum = 124;BA.debugLine="CallSub(Main,\"total_off\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._main.getObject()),"total_off");
 };
 //BA.debugLineNum = 127;BA.debugLine="End Sub";
return "";
}
public static String  _cb_onscanprogress(int _current,int _total) throws Exception{
 //BA.debugLineNum = 78;BA.debugLine="Sub cb_onScanProgress(Current As Int , Total As In";
 //BA.debugLineNum = 79;BA.debugLine="kvsdata.Put(\"to\",Total)";
_kvsdata._put("to",(Object)(_total));
 //BA.debugLineNum = 80;BA.debugLine="kvsdata.Put(\"c\",Current)";
_kvsdata._put("c",(Object)(_current));
 //BA.debugLineNum = 81;BA.debugLine="CallSub(Widget,\"prog_update\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._widget.getObject()),"prog_update");
 //BA.debugLineNum = 82;BA.debugLine="CallSubDelayed (Main,\"pb_update\")";
anywheresoftware.b4a.keywords.Common.CallSubDelayed(processBA,(Object)(mostCurrent._main.getObject()),"pb_update");
 //BA.debugLineNum = 83;BA.debugLine="CallSub(info,\"c_update\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._info.getObject()),"c_update");
 //BA.debugLineNum = 84;BA.debugLine="Log(\"Scan: \"&Current&\" /\"&Total)";
anywheresoftware.b4a.keywords.Common.Log("Scan: "+BA.NumberToString(_current)+" /"+BA.NumberToString(_total));
 //BA.debugLineNum = 86;BA.debugLine="End Sub";
return "";
}
public static String  _cb_onscanstarted() throws Exception{
 //BA.debugLineNum = 72;BA.debugLine="Sub cb_OnScanStarted";
 //BA.debugLineNum = 73;BA.debugLine="Log(\"Started\")";
anywheresoftware.b4a.keywords.Common.Log("Started");
 //BA.debugLineNum = 74;BA.debugLine="CallSub(info,\"c_start\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._info.getObject()),"c_start");
 //BA.debugLineNum = 75;BA.debugLine="End Sub";
return "";
}
public static String  _clean_start() throws Exception{
 //BA.debugLineNum = 129;BA.debugLine="Sub clean_start";
 //BA.debugLineNum = 130;BA.debugLine="cb.CleanCache";
_cb.CleanCache();
 //BA.debugLineNum = 131;BA.debugLine="CallSub(info,\"c_clean\")";
anywheresoftware.b4a.keywords.Common.CallSubNew(processBA,(Object)(mostCurrent._info.getObject()),"c_clean");
 //BA.debugLineNum = 132;BA.debugLine="Log(\"start\")";
anywheresoftware.b4a.keywords.Common.Log("start");
 //BA.debugLineNum = 133;BA.debugLine="End Sub";
return "";
}
public static String  _formatfilesize(float _bytes) throws Exception{
String[] _unit = null;
double _po = 0;
double _si = 0;
int _i = 0;
 //BA.debugLineNum = 145;BA.debugLine="Sub FormatFileSize(Bytes As Float) As String";
 //BA.debugLineNum = 146;BA.debugLine="Private Unit() As String = Array As String(\" Byte";
_unit = new String[]{" Byte"," KB"," MB"," GB"," TB"," PB"," EB"," ZB"," YB"};
 //BA.debugLineNum = 147;BA.debugLine="If Bytes = 0 Then";
if (_bytes==0) { 
 //BA.debugLineNum = 148;BA.debugLine="Return \"0 Bytes\"";
if (true) return "0 Bytes";
 }else {
 //BA.debugLineNum = 150;BA.debugLine="Private Po, Si As Double";
_po = 0;
_si = 0;
 //BA.debugLineNum = 151;BA.debugLine="Private I As Int";
_i = 0;
 //BA.debugLineNum = 152;BA.debugLine="Bytes = Abs(Bytes)";
_bytes = (float) (anywheresoftware.b4a.keywords.Common.Abs(_bytes));
 //BA.debugLineNum = 153;BA.debugLine="I = Floor(Logarithm(Bytes, 1024))";
_i = (int) (anywheresoftware.b4a.keywords.Common.Floor(anywheresoftware.b4a.keywords.Common.Logarithm(_bytes,1024)));
 //BA.debugLineNum = 154;BA.debugLine="Po = Power(1024, I)";
_po = anywheresoftware.b4a.keywords.Common.Power(1024,_i);
 //BA.debugLineNum = 155;BA.debugLine="Si = Bytes / Po";
_si = _bytes/(double)_po;
 //BA.debugLineNum = 156;BA.debugLine="Return NumberFormat(Si, 1, 2) & Unit(I)";
if (true) return anywheresoftware.b4a.keywords.Common.NumberFormat(_si,(int) (1),(int) (2))+_unit[_i];
 };
 //BA.debugLineNum = 158;BA.debugLine="End Sub";
return "";
}
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 5;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 8;BA.debugLine="Private cb As CacheCleaner";
_cb = new anywheresoftware.b4a.cachecleaner.CacheCleaner();
 //BA.debugLineNum = 9;BA.debugLine="Dim t2,t3 As Timer";
_t2 = new anywheresoftware.b4a.objects.Timer();
_t3 = new anywheresoftware.b4a.objects.Timer();
 //BA.debugLineNum = 10;BA.debugLine="Private name,apath,l,Types(1),packName As String";
_name = "";
_apath = "";
_l = "";
_types = new String[(int) (1)];
java.util.Arrays.fill(_types,"");
_packname = "";
 //BA.debugLineNum = 11;BA.debugLine="Dim app() As Object";
_app = new Object[(int) (0)];
{
int d0 = _app.length;
for (int i0 = 0;i0 < d0;i0++) {
_app[i0] = new Object();
}
}
;
 //BA.debugLineNum = 12;BA.debugLine="Dim counter As Int";
_counter = 0;
 //BA.debugLineNum = 13;BA.debugLine="Private cts As CustomToast";
_cts = new com.rootsoft.customtoast.CustomToast();
 //BA.debugLineNum = 14;BA.debugLine="Dim piclist As List";
_piclist = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 15;BA.debugLine="Dim obj As List";
_obj = new anywheresoftware.b4a.objects.collections.List();
 //BA.debugLineNum = 16;BA.debugLine="Dim date,time As String";
_date = "";
_time = "";
 //BA.debugLineNum = 17;BA.debugLine="Dim dir As String=File.DirInternal&\"/Bdata\"";
_dir = anywheresoftware.b4a.keywords.Common.File.getDirInternal()+"/Bdata";
 //BA.debugLineNum = 18;BA.debugLine="Private kvst,kvsdata,alist,dbase,abase As KeyValu";
_kvst = new de.sclean.keyvaluestore();
_kvsdata = new de.sclean.keyvaluestore();
_alist = new de.sclean.keyvaluestore();
_dbase = new de.sclean.keyvaluestore();
_abase = new de.sclean.keyvaluestore();
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return "";
}
public static String  _remote_start() throws Exception{
 //BA.debugLineNum = 63;BA.debugLine="Sub remote_start";
 //BA.debugLineNum = 64;BA.debugLine="cb.ScanCache";
_cb.ScanCache();
 //BA.debugLineNum = 65;BA.debugLine="kvst.DeleteAll";
_kvst._deleteall();
 //BA.debugLineNum = 67;BA.debugLine="End Sub";
return "";
}
public static String  _rv_off() throws Exception{
 //BA.debugLineNum = 60;BA.debugLine="Sub rv_off";
 //BA.debugLineNum = 61;BA.debugLine="StopService(info)";
anywheresoftware.b4a.keywords.Common.StopService(processBA,(Object)(mostCurrent._info.getObject()));
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return "";
}
public static String  _rv_on() throws Exception{
 //BA.debugLineNum = 57;BA.debugLine="Sub rv_on";
 //BA.debugLineNum = 58;BA.debugLine="StartService(info)";
anywheresoftware.b4a.keywords.Common.StartService(processBA,(Object)(mostCurrent._info.getObject()));
 //BA.debugLineNum = 59;BA.debugLine="End Sub";
return "";
}
public static String  _service_create() throws Exception{
 //BA.debugLineNum = 23;BA.debugLine="Sub Service_Create";
 //BA.debugLineNum = 25;BA.debugLine="DateTime.TimeFormat=\"HH:mm\"";
anywheresoftware.b4a.keywords.Common.DateTime.setTimeFormat("HH:mm");
 //BA.debugLineNum = 26;BA.debugLine="DateTime.DateFormat=\"dd.MM.yyy\"";
anywheresoftware.b4a.keywords.Common.DateTime.setDateFormat("dd.MM.yyy");
 //BA.debugLineNum = 27;BA.debugLine="date=DateTime.Date(DateTime.Now)";
_date = anywheresoftware.b4a.keywords.Common.DateTime.Date(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 28;BA.debugLine="time=DateTime.Time(DateTime.Now)";
_time = anywheresoftware.b4a.keywords.Common.DateTime.Time(anywheresoftware.b4a.keywords.Common.DateTime.getNow());
 //BA.debugLineNum = 29;BA.debugLine="kvst.Initialize(File.DirInternal,\"data_time\")";
_kvst._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_time");
 //BA.debugLineNum = 30;BA.debugLine="kvsdata.Initialize(File.DirInternal,\"data_data\")";
_kvsdata._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"data_data");
 //BA.debugLineNum = 31;BA.debugLine="alist.Initialize(File.DirInternal,\"adata_data\")";
_alist._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"adata_data");
 //BA.debugLineNum = 32;BA.debugLine="dbase.Initialize(File.DirInternal,\"dbase_data\")";
_dbase._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"dbase_data");
 //BA.debugLineNum = 33;BA.debugLine="abase.Initialize(File.DirInternal,\"abase_data\")";
_abase._initialize(processBA,anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"abase_data");
 //BA.debugLineNum = 35;BA.debugLine="piclist.Initialize";
_piclist.Initialize();
 //BA.debugLineNum = 36;BA.debugLine="obj.Initialize";
_obj.Initialize();
 //BA.debugLineNum = 37;BA.debugLine="cb.initialize(\"cb\")";
_cb.initialize("cb",processBA);
 //BA.debugLineNum = 38;BA.debugLine="cts.Initialize";
_cts.Initialize(processBA);
 //BA.debugLineNum = 39;BA.debugLine="counter=0";
_counter = (int) (0);
 //BA.debugLineNum = 40;BA.debugLine="t2.Initialize(\"t2\",1000)";
_t2.Initialize(processBA,"t2",(long) (1000));
 //BA.debugLineNum = 41;BA.debugLine="t3.Initialize(\"t3\",1000)";
_t3.Initialize(processBA,"t3",(long) (1000));
 //BA.debugLineNum = 42;BA.debugLine="t3.Enabled=False";
_t3.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 43;BA.debugLine="If Not(File.IsDirectory(File.DirInternal,\"Bdata\")";
if (anywheresoftware.b4a.keywords.Common.Not(anywheresoftware.b4a.keywords.Common.File.IsDirectory(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Bdata"))) { 
 //BA.debugLineNum = 44;BA.debugLine="File.MakeDir(File.DirInternal,\"Bdata/temp\")";
anywheresoftware.b4a.keywords.Common.File.MakeDir(anywheresoftware.b4a.keywords.Common.File.getDirInternal(),"Bdata/temp");
 //BA.debugLineNum = 45;BA.debugLine="File.WriteList(dir,\"clist.txt\",obj)";
anywheresoftware.b4a.keywords.Common.File.WriteList(_dir,"clist.txt",_obj);
 };
 //BA.debugLineNum = 47;BA.debugLine="End Sub";
return "";
}
public static String  _service_destroy() throws Exception{
 //BA.debugLineNum = 53;BA.debugLine="Sub Service_Destroy";
 //BA.debugLineNum = 54;BA.debugLine="t2.Enabled=False";
_t2.setEnabled(anywheresoftware.b4a.keywords.Common.False);
 //BA.debugLineNum = 55;BA.debugLine="End Sub";
return "";
}
public static String  _service_start(anywheresoftware.b4a.objects.IntentWrapper _startingintent) throws Exception{
 //BA.debugLineNum = 49;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
 //BA.debugLineNum = 51;BA.debugLine="End Sub";
return "";
}
public static String  _wid_start() throws Exception{
 //BA.debugLineNum = 68;BA.debugLine="Sub wid_start";
 //BA.debugLineNum = 69;BA.debugLine="cb.ScanCache";
_cb.ScanCache();
 //BA.debugLineNum = 70;BA.debugLine="End Sub";
return "";
}
}

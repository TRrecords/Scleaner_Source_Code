package de.sclean;


import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.debug.*;

public class animator {
private static animator mostCurrent = new animator();
public static Object getObject() {
    throw new RuntimeException("Code module does not support this method.");
}
 public anywheresoftware.b4a.keywords.Common __c = null;
public static String _setanimat = "";
public de.sclean.main _main = null;
public de.sclean.supp _supp = null;
public de.sclean.option _option = null;
public de.sclean.starter _starter = null;
public de.sclean.widget _widget = null;
public de.sclean.statemanager _statemanager = null;
public de.sclean.info _info = null;
public static String  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 5;BA.debugLine="Dim setanimat As String";
_setanimat = "";
 //BA.debugLineNum = 6;BA.debugLine="End Sub";
return "";
}
public static String  _setanimati(anywheresoftware.b4a.BA _ba,String _inanimation,String _outanimation) throws Exception{
anywheresoftware.b4a.agraham.reflection.Reflection _r = null;
String _package = "";
int _in = 0;
int _out = 0;
 //BA.debugLineNum = 9;BA.debugLine="Sub SetAnimati(InAnimation As String, OutAnimation";
 //BA.debugLineNum = 10;BA.debugLine="Dim r As Reflector";
_r = new anywheresoftware.b4a.agraham.reflection.Reflection();
 //BA.debugLineNum = 11;BA.debugLine="Dim package As String";
_package = "";
 //BA.debugLineNum = 12;BA.debugLine="Dim in, out As Int";
_in = 0;
_out = 0;
 //BA.debugLineNum = 13;BA.debugLine="package = r.GetStaticField(\"anywheresoftware.b4a.";
_package = BA.ObjectToString(_r.GetStaticField("anywheresoftware.b4a.BA","packageName"));
 //BA.debugLineNum = 14;BA.debugLine="in = r.GetStaticField(package & \".R$anim\", InAnim";
_in = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$anim",_inanimation)));
 //BA.debugLineNum = 15;BA.debugLine="out = r.GetStaticField(package & \".R$anim\", OutAn";
_out = (int)(BA.ObjectToNumber(_r.GetStaticField(_package+".R$anim",_outanimation)));
 //BA.debugLineNum = 16;BA.debugLine="r.Target = r.GetActivity";
_r.Target = (Object)(_r.GetActivity((_ba.processBA == null ? _ba : _ba.processBA)));
 //BA.debugLineNum = 17;BA.debugLine="r.RunMethod4(\"overridePendingTransition\", Array A";
_r.RunMethod4("overridePendingTransition",new Object[]{(Object)(_in),(Object)(_out)},new String[]{"java.lang.int","java.lang.int"});
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return "";
}
}

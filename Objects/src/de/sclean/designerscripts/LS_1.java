package de.sclean.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_1{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
//BA.debugLineNum = 2;BA.debugLine="AutoScaleAll"[1/General script]
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
//BA.debugLineNum = 3;BA.debugLine="toolbar.SetTopAndBottom(0,10%y)"[1/General script]
views.get("toolbar").vw.setTop((int)(0d));
views.get("toolbar").vw.setHeight((int)((10d / 100 * height) - (0d)));
//BA.debugLineNum = 4;BA.debugLine="toolbar.SetLeftAndRight(0,100%x)"[1/General script]
views.get("toolbar").vw.setLeft((int)(0d));
views.get("toolbar").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 5;BA.debugLine="prb.SetTopAndBottom(50%y,62%y)"[1/General script]
views.get("prb").vw.setTop((int)((50d / 100 * height)));
views.get("prb").vw.setHeight((int)((62d / 100 * height) - ((50d / 100 * height))));
//BA.debugLineNum = 6;BA.debugLine="prb.SetLeftAndRight(35%x,65%x)"[1/General script]
views.get("prb").vw.setLeft((int)((35d / 100 * width)));
views.get("prb").vw.setWidth((int)((65d / 100 * width) - ((35d / 100 * width))));
//BA.debugLineNum = 7;BA.debugLine="ipan2.SetTopAndBottom(toolbar.Bottom,100%y)"[1/General script]
views.get("ipan2").vw.setTop((int)((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight())));
views.get("ipan2").vw.setHeight((int)((100d / 100 * height) - ((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight()))));
//BA.debugLineNum = 8;BA.debugLine="ipan2.SetLeftAndRight(0,100%x)"[1/General script]
views.get("ipan2").vw.setLeft((int)(0d));
views.get("ipan2").vw.setWidth((int)((100d / 100 * width) - (0d)));
//BA.debugLineNum = 9;BA.debugLine="lv1.SetLeftAndRight(1%x,99%x)"[1/General script]
views.get("lv1").vw.setLeft((int)((1d / 100 * width)));
views.get("lv1").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 10;BA.debugLine="lv1.SetTopAndBottom(23%y,40%y)"[1/General script]
views.get("lv1").vw.setTop((int)((23d / 100 * height)));
views.get("lv1").vw.setHeight((int)((40d / 100 * height) - ((23d / 100 * height))));
//BA.debugLineNum = 11;BA.debugLine="extrapan.SetLeftAndRight(1%x,99%x)"[1/General script]
views.get("extrapan").vw.setLeft((int)((1d / 100 * width)));
views.get("extrapan").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
//BA.debugLineNum = 12;BA.debugLine="extrapan.SetTopAndBottom(lv1.Bottom,89%y)"[1/General script]
views.get("extrapan").vw.setTop((int)((views.get("lv1").vw.getTop() + views.get("lv1").vw.getHeight())));
views.get("extrapan").vw.setHeight((int)((89d / 100 * height) - ((views.get("lv1").vw.getTop() + views.get("lv1").vw.getHeight()))));
//BA.debugLineNum = 13;BA.debugLine="tota.SetTopAndBottom(62%y,88%y)"[1/General script]
views.get("tota").vw.setTop((int)((62d / 100 * height)));
views.get("tota").vw.setHeight((int)((88d / 100 * height) - ((62d / 100 * height))));
//BA.debugLineNum = 14;BA.debugLine="tota.SetLeftAndRight(3%x,97%x)"[1/General script]
views.get("tota").vw.setLeft((int)((3d / 100 * width)));
views.get("tota").vw.setWidth((int)((97d / 100 * width) - ((3d / 100 * width))));
//BA.debugLineNum = 15;BA.debugLine="pb1.Top=toolbar.Bottom+5dip"[1/General script]
views.get("pb1").vw.setTop((int)((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 16;BA.debugLine="pb1.Left=1%x"[1/General script]
views.get("pb1").vw.setLeft((int)((1d / 100 * width)));
//BA.debugLineNum = 17;BA.debugLine="pb2.Top=toolbar.Bottom+5dip"[1/General script]
views.get("pb2").vw.setTop((int)((views.get("toolbar").vw.getTop() + views.get("toolbar").vw.getHeight())+(5d * scale)));
//BA.debugLineNum = 18;BA.debugLine="pb2.Right=99%x"[1/General script]
views.get("pb2").vw.setLeft((int)((99d / 100 * width) - (views.get("pb2").vw.getWidth())));

}
}
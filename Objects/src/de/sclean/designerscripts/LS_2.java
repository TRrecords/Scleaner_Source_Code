package de.sclean.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_2{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setLeft((int)(0d));
views.get("panel1").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("panel1").vw.setTop((int)(0d));
views.get("panel1").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("mtext").vw.setTop((int)((1d * scale)));
views.get("mtext").vw.setHeight((int)((10d / 100 * height) - ((1d * scale))));
views.get("mtext").vw.setLeft((int)((1d / 100 * width)));
views.get("mtext").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
views.get("ctext").vw.setLeft((int)((1d / 100 * width)));
views.get("ctext").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
views.get("ctext").vw.setTop((int)((views.get("mtext").vw.getTop() + views.get("mtext").vw.getHeight())+(1d * scale)));
views.get("ctext").vw.setHeight((int)((20d / 100 * height) - ((views.get("mtext").vw.getTop() + views.get("mtext").vw.getHeight())+(1d * scale))));
views.get("acb1").vw.setLeft((int)((1d / 100 * width)));
views.get("acb1").vw.setWidth((int)((750d / 100 * width) - ((1d / 100 * width))));
views.get("acb1").vw.setHeight((int)((50d * scale)));
views.get("acb1").vw.setTop((int)((21d / 100 * height)));
views.get("lv2").vw.setTop((int)((views.get("acb1").vw.getTop() + views.get("acb1").vw.getHeight())+(1d * scale)));
views.get("lv2").vw.setHeight((int)((90d / 100 * height) - ((views.get("acb1").vw.getTop() + views.get("acb1").vw.getHeight())+(1d * scale))));
views.get("lv2").vw.setLeft((int)((1d / 100 * width)));
views.get("lv2").vw.setWidth((int)((99d / 100 * width) - ((1d / 100 * width))));
views.get("ab1").vw.setTop((int)((views.get("lv2").vw.getTop() + views.get("lv2").vw.getHeight())));
views.get("ab1").vw.setHeight((int)((99d / 100 * height) - ((views.get("lv2").vw.getTop() + views.get("lv2").vw.getHeight()))));
views.get("ab1").vw.setLeft((int)((35d / 100 * width)));
views.get("ab1").vw.setWidth((int)((65d / 100 * width) - ((35d / 100 * width))));

}
}
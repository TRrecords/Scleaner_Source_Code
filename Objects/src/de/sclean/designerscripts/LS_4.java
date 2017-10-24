package de.sclean.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_4{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setTop((int)(0d));
views.get("panel1").vw.setHeight((int)((100d / 100 * height) - (0d)));
views.get("panel1").vw.setLeft((int)(0d));
views.get("panel1").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("label1").vw.setLeft((int)(0d));
views.get("label1").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("label1").vw.setTop((int)(0d));
views.get("label1").vw.setHeight((int)((20d / 100 * height) - (0d)));
views.get("edittext1").vw.setTop((int)((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight())));
views.get("edittext1").vw.setHeight((int)((30d / 100 * height) - ((views.get("label1").vw.getTop() + views.get("label1").vw.getHeight()))));
views.get("edittext2").vw.setTop((int)((views.get("edittext1").vw.getTop() + views.get("edittext1").vw.getHeight())));
views.get("edittext2").vw.setHeight((int)((40d / 100 * height) - ((views.get("edittext1").vw.getTop() + views.get("edittext1").vw.getHeight()))));
views.get("edittext1").vw.setLeft((int)(0d));
views.get("edittext1").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("edittext2").vw.setLeft((int)(0d));
views.get("edittext2").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("ace").vw.setTop((int)((views.get("edittext2").vw.getTop() + views.get("edittext2").vw.getHeight())));
views.get("ace").vw.setHeight((int)((90d / 100 * height) - ((views.get("edittext2").vw.getTop() + views.get("edittext2").vw.getHeight()))));
views.get("ace").vw.setLeft((int)(0d));
views.get("ace").vw.setWidth((int)((100d / 100 * width) - (0d)));
views.get("acb1").vw.setTop((int)((views.get("ace").vw.getTop() + views.get("ace").vw.getHeight())));
views.get("acb1").vw.setHeight((int)((100d / 100 * height) - ((views.get("ace").vw.getTop() + views.get("ace").vw.getHeight()))));
views.get("acb1").vw.setLeft((int)((30d / 100 * width)));
views.get("acb1").vw.setWidth((int)((70d / 100 * width) - ((30d / 100 * width))));

}
}
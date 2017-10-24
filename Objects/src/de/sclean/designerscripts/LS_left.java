package de.sclean.designerscripts;
import anywheresoftware.b4a.objects.TextViewWrapper;
import anywheresoftware.b4a.objects.ImageViewWrapper;
import anywheresoftware.b4a.BA;


public class LS_left{

public static void LS_general(java.util.LinkedHashMap<String, anywheresoftware.b4a.keywords.LayoutBuilder.ViewWrapperAndAnchor> views, int width, int height, float scale) {
anywheresoftware.b4a.keywords.LayoutBuilder.setScaleRate(0.3);
anywheresoftware.b4a.keywords.LayoutBuilder.scaleAll(views);
views.get("panel1").vw.setLeft((int)((0d / 100 * width)));
views.get("panel1").vw.setWidth((int)((80d / 100 * width) - ((0d / 100 * width))));
views.get("panel1").vw.setTop((int)((0d / 100 * height)));
views.get("panel1").vw.setHeight((int)((100d / 100 * height) - ((0d / 100 * height))));
views.get("leftlist").vw.setLeft((int)((2d / 100 * width)));
views.get("leftlist").vw.setWidth((int)((78d / 100 * width) - ((2d / 100 * width))));
views.get("leftlist").vw.setTop((int)((2d / 100 * height)));
views.get("leftlist").vw.setHeight((int)((48d / 100 * height) - ((2d / 100 * height))));

}
}
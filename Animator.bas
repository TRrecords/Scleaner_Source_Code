Type=StaticCode
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code Module by trOw animation by Sulomedia
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim setanimat As String
End Sub


Sub SetAnimati(InAnimation As String, OutAnimation As String)
	Dim r As Reflector
	Dim package As String
	Dim in, out As Int
	package = r.GetStaticField("anywheresoftware.b4a.BA", "packageName")
	in = r.GetStaticField(package & ".R$anim", InAnimation)
	out = r.GetStaticField(package & ".R$anim", OutAnimation)
	r.Target = r.GetActivity
	r.RunMethod4("overridePendingTransition", Array As Object(in, out), Array As String("java.lang.int", "java.lang.int"))

End Sub
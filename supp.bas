Type=Activity
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: False
	#IncludeTitle: True
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Private rfont As Typeface= rfont.LoadFromAssets("Aldrich-Regular.ttf")
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private acb1 As ACFlatButton
	Private ace As ACEditText
	Private EditText1 As EditText
	Private EditText2 As EditText
	Private Label1 As Label
	Private Panel1 As Panel
	Private qbase As KeyValueStore
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("4")
	'#### Label####################
		Label1.TextSize=15
		Label1.Typeface=rfont
		Label1.Gravity=Gravity.FILL
		Label1.Text="Teile uns Verbesserungen oder Vorschläge mit um S-cleaner noch besser für dich zu machen! Wir Antworten so schnell wie möglich auf deine Anfrage und freuen uns über jeden neuen Vorschlag oder Hinweis."
	'#### edit namr ###############
	EditText1.Hint="Name"
	EditText1.ForceDoneButton=True
	'##### edit email m###########
	EditText2.hint="Email Adresse"
	EditText2.ForceDoneButton=True
	EditText1.Typeface=rfont
	EditText2.Typeface=rfont
	acb1.Text="Senden"
	acb1.Typeface=rfont
	acb1.Gravity=Gravity.CENTER
	'######Text options ####################################
		ace.TextSize=15
		ace.Typeface=rfont
		ace.Gravity=Gravity.TOP
		ace.Hint="Schreibe uns was du denkst.."
	'##############################SQL Values ###############################
	qbase.Initialize(File.DirInternal,"qbase_data")
	
	
	
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub EditText2_TextChanged (Old As String, New As String)
	If qbase.ContainsKey("name") Then 
		qbase.Remove("name")
		qbase.Put("name",New)
	Else 
		qbase.Put("name",New)
	End If
End Sub

Sub EditText1_TextChanged (Old As String, New As String)
	If qbase.ContainsKey("mail") Then
		qbase.Remove("mail")
		qbase.Put("mail",New)
	Else
		qbase.Put("mail",New)
	End If
End Sub

Sub ace_TextChanged (Old As String, New As String)
	If qbase.ContainsKey("text") Then
		qbase.Remove("text")
		qbase.Put("text",New)
	Else
		qbase.Put("text",New)
	End If
End Sub

Sub acb1_Click
	Dim Message As Email
	Message.To.Add("info@sulomedia.de")
	Message.Body=qbase.Get("text")
	'Message.CC.Add(qbase.Get("mail"))
	'Message.BCC.Add(qbase.Get("mail"))
	StartActivity(Message.GetIntent)
	ToastMessageShow("Vielen Dank deine Anfrage wird verarbeitet, öffne E-mail Programm..",False)
	qbase.DeleteAll
	Activity.Finish
	Animator.setanimati("extra_in", "extra_out")
End Sub

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
	Private rfont As Typeface= rfont.LoadFromAssets("Aldrich-Regular.ttf")
End Sub

Sub Globals
	Private acb1 As ACCheckBox
	Private Ctext As Label
	Private Mtext As Label
	Private Panel1 As Panel
	Private ab1 As ACButton
	Private lv2 As ListView
	Private mcl As MaterialColors
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Activity.LoadLayout("2")
	Mtext.Typeface=rfont
	Ctext.Typeface=rfont
	acb1.TextSize=12
	acb1.Typeface=rfont
	acb1.Text="Service Modul: Deaktiviert"
	ab1.Text="zurück"
	ab1.Typeface=rfont
	Dim cs As CSBuilder
	cs.Initialize.Alignment("ALIGN_CENTER").Append("Einstellungen").PopAll
	Mtext.Text=cs	
	If StateManager.RestoreState(Activity, "option", 0) = False Then
		acb1.Checked=False
	End If
	c_text
End Sub

Sub Activity_Resume
	
End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub Activity_KeyPress (KeyCode As Int) As Boolean 'Return True to consume the event
	If KeyCode=KeyCodes.KEYCODE_BACK Then
		Activity.Finish
		Animator.setanimati("extra_in", "extra_out")
	End If
	Return(True)
End Sub

Sub c_text
	Dim cs As CSBuilder
	cs.Initialize.Color(mcl.md_blue_grey_900).Append("Hier wird das 'Cleaner Service Module' Aktiviert oder Deaktiviert, Standart: ")
	cs.Bold.Color(mcl.md_amber_700).Append("Deaktiviert").Pop.PopAll
	Ctext.Text=cs
End Sub

Sub acb1_CheckedChange(Checked As Boolean)
	Select Checked
		Case True 
			StartService(info)
			acb1.Text="Service: Aktiviert"
		Case False 
			acb1.Text="Service: Deaktiviert"
			StopService(info)
	End Select
End Sub

Sub lv2_ItemClick (Position As Int, Value As Object)
	
End Sub

Sub ab1_Click
	StateManager.SaveState(Activity,"option")
	Activity.Finish
	Animator.setanimati("extra_in", "extra_out")
End Sub
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Lab_4_B_In_1_File.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <script language="C#" runat="server">
        protected void Button1_Click(object sender, EventArgs e)
        {
            if (nameTextBox.Text.Equals("") ||
                emailTextBox.Text.Equals("") ||
                phoneTextBox.Text.Equals("") ||
                passwordTextBox.Text.Equals(""))
            {
                resultLabel.Text = "Not all fields are filled";
            }
            else if (!CheckBox1.Checked)
            {
                resultLabel.Text = "You are not agreed with terms";
            }
            else { 
                resultLabel.Text = "Successfully registered!";
            }
        }
    </script>
    <form id="form1" runat="server">
        <div>
        </div>
        <asp:Label ID="Label1" runat="server" Text="Name: "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="nameTextBox" runat="server" Width="161px"></asp:TextBox>
        <br />
        <asp:Label ID="Label2" runat="server" Text="Email: "></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="emailTextBox" runat="server" Width="161px"></asp:TextBox>
        <br />
        <asp:Label ID="Label3" runat="server" Text="Phone:"></asp:Label>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:TextBox ID="phoneTextBox" runat="server" Width="161px"></asp:TextBox>
        <br />
        <asp:Label ID="Label4" runat="server" Text="Password:"></asp:Label>
&nbsp;
        <asp:TextBox ID="passwordTextBox" type="password" runat="server" Width="161px"></asp:TextBox>
        <br />
        <asp:CheckBox ID="CheckBox1" runat="server" Text="I agree with terms." TextAlign="Left" />
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Sign up" />
        <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:Label ID="resultLabel" runat="server"></asp:Label>
    </form>
</body>
</html>

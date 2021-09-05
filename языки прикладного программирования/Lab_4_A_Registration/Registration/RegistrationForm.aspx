<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="RegistrationForm.aspx.cs" Inherits="RegisterForm.RegistrationForm" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        </div>
        <asp:Label ID="nameLabel" runat="server" Text="Name"></asp:Label>
&nbsp;
        <asp:TextBox ID="nameTextBox" runat="server" MaxLength="10"></asp:TextBox>
        <asp:RequiredFieldValidator id="RequiredFieldValidator2"
                    ControlToValidate="nameTextBox"
                    Display="Static"
                    ErrorMessage="Empty name"
                    runat="server"/> 
        <br />
        <asp:Label ID="emailLabel" runat="server" Text="Email"></asp:Label>
&nbsp;&nbsp;<asp:TextBox ID="emailTextBox" runat="server"></asp:TextBox>
        <asp:RegularExpressionValidator id="RegularExpressionValidator1" 
                     ControlToValidate="emailTextBox"
                     ValidationExpression="^[a-zA-Z0-9_]+[a-zA-Z0-9_\.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"
                     Display="Static"
                     ErrorMessage="Incorrect email"
                     EnableClientScript="False" 
                     runat="server"/>
        <asp:RequiredFieldValidator id="RequiredFieldValidator1"
                    ControlToValidate="emailTextBox"
                    Display="Static"
                    ErrorMessage="Empty email"
                    runat="server" EnableClientScript="False"/>
        <br />
        <br />
&nbsp;&nbsp;&nbsp;
        <asp:Button ID="submitButton" runat="server" OnClick="submitButton_Click" Text="Submit" />
        <br />
        <asp:Label ID="resultLabel" runat="server"></asp:Label>
    </form>
</body>
</html>

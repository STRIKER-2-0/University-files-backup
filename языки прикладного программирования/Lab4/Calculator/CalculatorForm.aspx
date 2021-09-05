<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="CalculatorForm.aspx.cs" Inherits="Calculator.CalculatorForm" %>

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
        <h3>Calculator</h3>
        <asp:TextBox ID="operand1" runat="server" Width="55px"></asp:TextBox>
        <asp:DropDownList ID="operator" runat="server">
            <asp:ListItem>+</asp:ListItem>
            <asp:ListItem>-</asp:ListItem>
            <asp:ListItem>*</asp:ListItem>
            <asp:ListItem>/</asp:ListItem>
        </asp:DropDownList>
        <asp:TextBox ID="operand2" runat="server" Width="41px"></asp:TextBox>
        <asp:Label ID="resultLabel" runat="server" Visible="False"></asp:Label>
        <br />
        <br />
        <asp:Button ID="solveButton" runat="server" OnClick="solveButton_Click" Text="Solve" style="margin-top: 0px" Width="55px" />
        &nbsp;&nbsp;&nbsp;
        <asp:Button ID="clearButton" runat="server" OnClick="clearButton_Click" Text="Clear" Width="54px" />
    </form>
</body>
</html>

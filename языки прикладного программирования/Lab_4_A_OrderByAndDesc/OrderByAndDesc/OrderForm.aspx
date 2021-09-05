<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="OrderForm.aspx.cs" Inherits="OrderByAndDesc.OrderForm" %>

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
        <asp:TextBox ID="inputTextBox" runat="server"></asp:TextBox>
        <asp:Button ID="solve" runat="server" OnClick="solve_Click" Text="Solve" />
        <br />
        <asp:Label ID="orderLabel" runat="server" Text="Order: "></asp:Label>
        <br />
        <asp:Label ID="descLabel" runat="server" Text="Desc:"></asp:Label>
    </form>
</body>
</html>

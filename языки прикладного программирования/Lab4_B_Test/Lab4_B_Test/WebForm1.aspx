<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Lab4_B_Test.WebForm1" %>

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
        <asp:Label ID="Label1" runat="server" Text="1. London is the capital of:"></asp:Label>
&nbsp;
        <asp:DropDownList ID="capitalList" runat="server">
            <asp:ListItem>Great Britain</asp:ListItem>
            <asp:ListItem>Україна</asp:ListItem>
            <asp:ListItem>Mars</asp:ListItem>
        </asp:DropDownList>
        <br />
        <asp:Label ID="Label2" runat="server" Text="2. 2 + 2 ="></asp:Label>
&nbsp;
        <asp:DropDownList ID="sumList" runat="server">
            <asp:ListItem>4</asp:ListItem>
            <asp:ListItem>5</asp:ListItem>
            <asp:ListItem>+-Infinity</asp:ListItem>
        </asp:DropDownList>
        <br />
        <asp:Label ID="Label3" runat="server" Text="3. Что тяжелее: килограмм ваты, или килограмм железа?"></asp:Label>
&nbsp;
        <asp:DropDownList ID="kiloList" runat="server">
            <asp:ListItem>Вата</asp:ListItem>
            <asp:ListItem>Железо</asp:ListItem>
            <asp:ListItem>Алмазы</asp:ListItem>
        </asp:DropDownList>
        <br />
        <br />
        <asp:Button runat="server" OnClick="Button1_Click" Text="отправить результаты" />
        <br />
        <br />
        <asp:Label ID="answersLabel" runat="server"></asp:Label>
        <br />
        <asp:Label ID="timerLabel" runat="server"></asp:Label>
    </form>
</body>
</html>

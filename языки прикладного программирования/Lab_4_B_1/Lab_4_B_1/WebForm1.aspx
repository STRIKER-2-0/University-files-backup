<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="Lab_4_B_1.WebForm1" %>

<%@ Register assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body id="mainPage" runat="server">
    <form id="form1" runat="server">
        <div>
        </div>
        Content:&nbsp;&nbsp;&nbsp;
        <asp:CheckBox ID="numbersBox" runat="server" Text="numbers" AutoPostBack="true" OnCheckedChanged="numbersBox_CheckedChanged"/>
        <asp:CheckBox ID="diagramBox" runat="server" Text="diagram" AutoPostBack="true" OnCheckedChanged="diagramBox_CheckedChanged"/>
        <asp:CheckBox ID="colorBox" runat="server" Text="color" AutoPostBack="true" OnCheckedChanged="colorBox_CheckedChanged"/>
        <br />
        <asp:TextBox ID="numbersTextBox" runat="server" Width="207px"></asp:TextBox>
        <asp:Button ID="numbersButton" runat="server" OnClick="numbersButton_Click" Text="Apply" Height="25px" />
        <asp:Label ID="numersErrorLabel" runat="server" Text="Incorrect Numbers" Visible="False"></asp:Label>
        <asp:RequiredFieldValidator id="RequiredFieldValidator2"
                    ControlToValidate="numbersTextBox"
                    Display="Static"
                    ErrorMessage="Empty name"
                    runat="server"/> 
        <br />
        <asp:Label ID="sumLabel" runat="server" Text="Sum:"></asp:Label>
        <br />
        <asp:Label ID="averageLabel" runat="server" Text="Average:"></asp:Label>
        <br />
        <asp:Label ID="maxLabel" runat="server" Text="Max:"></asp:Label>
        <br />
        <asp:Label ID="minLabel" runat="server" Text="Min:"></asp:Label>
        <br />
        <br />
        <asp:Label ID="diagramLabel" runat="server" Text="Diagram data:"></asp:Label>
        <br />
        <asp:Label ID="xLabel" runat="server" Text="X:"></asp:Label>
    &nbsp;
        <asp:TextBox ID="x1" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="x2" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="x3" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="x4" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="x5" runat="server"  Width="56px"></asp:TextBox>
        &nbsp;<asp:Button ID="diagramButton" runat="server" OnClick="diagramButton_Click" Text="Set data to chart" />
        &nbsp;<asp:Label ID="diagramErrorLabel" runat="server" Text="Incorrect Numbers" Visible="False"></asp:Label>
        <br />
        <asp:Label ID="yLabel" runat="server" Text="Y:"></asp:Label>
    &nbsp;
        <asp:TextBox ID="y1" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="y2" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="y3" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="y4" runat="server"  Width="56px"></asp:TextBox>
        <asp:TextBox ID="y5" runat="server"  Width="56px"></asp:TextBox>
        <br />
        <asp:Chart ID="chart" runat="server">
            <series>
                <asp:Series Name="Series1">
                </asp:Series>
            </series>
            <chartareas>
                <asp:ChartArea Name="ChartArea1">
                </asp:ChartArea>
            </chartareas>
        </asp:Chart>
        <br />
        <asp:TextBox ID="redTextBox" runat="server"  Width="69px"></asp:TextBox>
        <asp:TextBox ID="greenTextBox" runat="server"  Width="70px"></asp:TextBox>
        <asp:TextBox ID="blueTextBox" runat="server"  Width="84px"></asp:TextBox>
        <asp:Button ID="colorButton" runat="server" OnClick="colorButton_Click" Text="Change color of page" />
        <asp:Label ID="colorErrorLabel" runat="server" Text="Incorrect Numbers" Visible="False"></asp:Label>
    </form>
    <p>
        &nbsp;</p>
</body>
</html>

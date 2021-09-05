using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Calculator
{
    public partial class CalculatorForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void solveButton_Click(object sender, EventArgs e)
        {
            string operand1 = this.operand1.Text;
            string operand2 = this.operand2.Text;
            string separator = System.Threading.Thread.CurrentThread.CurrentCulture.NumberFormat.NumberDecimalSeparator;
            if (separator.Equals(","))
            {
                operand1 = operand1.Replace(".", separator);
                operand2 = operand2.Replace(".", separator);
            }
            else {
                operand1 = operand1.Replace(",", separator);
                operand2 = operand2.Replace(",", separator);
            }
            double a = 0;
            double b = 0;
            resultLabel.Visible = true;
            try
            {
                a = double.Parse(operand1);
                b = double.Parse(operand2);
            } catch (FormatException ex)
            {
                this.resultLabel.Text = "Incorrect operands";
                return;
            }
            string operation = @operator.Text;
            switch (operation)
            {
                case "+": resultLabel.Text = " = " + (a + b).ToString(); break;
                case "-": resultLabel.Text = " = " + (a - b).ToString(); break;
                case "*": resultLabel.Text = " = " + (a * b).ToString(); break;
                case "/": resultLabel.Text = " = " + (a / b).ToString(); break;
            }
        }

        protected void clearButton_Click(object sender, EventArgs e)
        {
            operand1.Text = "";
            operand2.Text = "";
        }
    }
}
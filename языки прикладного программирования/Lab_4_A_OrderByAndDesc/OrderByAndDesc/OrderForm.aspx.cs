using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace OrderByAndDesc
{
    public partial class OrderForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void solve_Click(object sender, EventArgs e)
        {
            string input = inputTextBox.Text;
            string[] numbersText = input.Trim().Split(' ');
            string separator = System.Threading.Thread.CurrentThread.CurrentCulture.NumberFormat.NumberDecimalSeparator;
            for (int i = 0; i < numbersText.Length; i++)
            {
                numbersText[i] = numbersText[i].Replace(separator.Equals(",") ? "." : ",", separator);
            }
            List<double> numbers = new List<double>();
            for (int i = 0; i < numbersText.Length; i++)
            {
                try
                {
                    numbers.Add(double.Parse(numbersText[i]));
                }
                catch (FormatException ex)
                {
                    orderLabel.Text = "Incorrect operands";
                    descLabel.Text = "";
                    return;
                }
            }
            numbers.Sort();
            orderLabel.Text = "Order: ";
            foreach (double number in numbers) {
                orderLabel.Text += number + " ";
            }
            numbers.Reverse();
            descLabel.Text = "Desc: ";
            foreach (double number in numbers)
            {
                descLabel.Text += number + " ";
            }
        }
    }
}
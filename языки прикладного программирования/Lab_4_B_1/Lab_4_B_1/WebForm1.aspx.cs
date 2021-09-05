using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.DataVisualization.Charting;
using System.Web.UI.WebControls;

namespace Lab_4_B_1
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        private string separator = System.Threading.Thread.CurrentThread.CurrentCulture.NumberFormat.NumberDecimalSeparator;
        protected void Page_Load(object sender, EventArgs e)
        {
            ScriptManager.ScriptResourceMapping.AddDefinition("jquery", new ScriptResourceDefinition
            {
                Path = "~/scripts/jquery-1.7.2.min.js",
            });
            numbersBox.Checked = minLabel.Visible;
            diagramBox.Checked = x1.Visible;
            colorBox.Checked = redTextBox.Visible;
        }
        private List<double> parse(TextBox textbox)
        {
            string[] numbersText = textbox.Text.Trim().Split(' ');
            string separator = System.Threading.Thread.CurrentThread.CurrentCulture.NumberFormat.NumberDecimalSeparator;
            for (int i = 0; i < numbersText.Length; i++)
            {
                numbersText[i] = numbersText[i].Replace(separator.Equals(",") ? "." : ",", separator);
            }
            List<double> numbers = new List<double>();
            for (int i = 0; i < numbersText.Length; i++)
            {
                numbers.Add(double.Parse(numbersText[i]));
            }
            return numbers;
        }

        protected void colorButton_Click(object sender, EventArgs e)
        {
            colorErrorLabel.Visible = true;
            double red = 0;
            double green = 0;
            double blue = 0;
            try
            {
                red = double.Parse(redTextBox.Text.Replace(separator.Equals(",") ? "." : ",", separator));
                green = double.Parse(greenTextBox.Text.Replace(separator.Equals(",") ? "." : ",", separator));
                blue = double.Parse(blueTextBox.Text.Replace(separator.Equals(",") ? "." : ",", separator));
                if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || green < 0) throw new FormatException();
            }
            catch (FormatException)
            {
                colorErrorLabel.Visible = true;
                return;
            }

            mainPage.Attributes["style"] = string.Format("background-color:rgb({0}, {1}, {2}); color:rgb({3},{4},{5})", red, green, blue, 255 - red, 255 - green, 255 - blue);
        }

        protected void diagramButton_Click(object sender, EventArgs e)
        {
            diagramErrorLabel.Visible = false;
            List<double> x = new List<double>();
            List<double> y = new List<double>();
            try
            {
                x.Add(parse(x1)[0]);
                x.Add(parse(x2)[0]);
                x.Add(parse(x3)[0]);
                x.Add(parse(x4)[0]);
                x.Add(parse(x5)[0]);
                y.Add(parse(y1)[0]);
                y.Add(parse(y2)[0]);
                y.Add(parse(y3)[0]);
                y.Add(parse(y4)[0]);
                y.Add(parse(y5)[0]);
            }
            catch (FormatException)
            {
                diagramErrorLabel.Visible = true;
                return;
            }
            chart.Series.Add(new Series("SplineSeries")
            {
                ChartType = SeriesChartType.Column,
                BorderWidth = 3,
                ShadowOffset = 2,
                Color = Color.PaleVioletRed
            });
            chart.Series[0].Points.DataBindXY(x, y);
        }

        protected void numbersButton_Click(object sender, EventArgs e)
        {
            numersErrorLabel.Visible = false;
            if (Page.IsValid) {
                List<double> numbers;
                try
                {
                    numbers = parse(numbersTextBox);
                }
                catch (FormatException)
                {
                    numersErrorLabel.Visible = true;
                    return;
                }
                double sum = 0;
                foreach (double number in numbers)
                {
                    sum += number;
                }
                sumLabel.Text = "Sum: " + sum;
                averageLabel.Text = "Average: " + sum / numbers.Count;
                maxLabel.Text = "Max: " + numbers.Max();
                minLabel.Text = "Min: " + numbers.Min();
            }
        }

        protected void numbersBox_CheckedChanged(object sender, EventArgs e)
        {
            numbersTextBox.Visible = !numbersTextBox.Visible;
            numbersButton.Visible = !numbersButton.Visible;
            numersErrorLabel.Visible = false;
            sumLabel.Visible = !sumLabel.Visible;
            averageLabel.Visible = !averageLabel.Visible;
            maxLabel.Visible = !maxLabel.Visible;
            minLabel.Visible = !minLabel.Visible;
            numbersBox.Checked = minLabel.Visible;
        }

        protected void diagramBox_CheckedChanged(object sender, EventArgs e)
        {
            diagramLabel.Visible = !diagramLabel.Visible;
            xLabel.Visible = !xLabel.Visible;
            yLabel.Visible = !yLabel.Visible;
            x1.Visible = !x1.Visible;
            x2.Visible = !x2.Visible;
            x3.Visible = !x3.Visible;
            x4.Visible = !x4.Visible;
            x5.Visible = !x5.Visible;
            y1.Visible = !y1.Visible;
            y2.Visible = !y2.Visible;
            y3.Visible = !y3.Visible;
            y4.Visible = !y4.Visible;
            y5.Visible = !y5.Visible;
            diagramButton.Visible = !diagramButton.Visible;
            diagramErrorLabel.Visible = false;
            chart.Visible = !chart.Visible;
            diagramBox.Checked = diagramLabel.Visible;
        }

        protected void colorBox_CheckedChanged(object sender, EventArgs e)
        {
            redTextBox.Visible = !redTextBox.Visible;
            greenTextBox.Visible = !greenTextBox.Visible;
            blueTextBox.Visible = !blueTextBox.Visible;
            colorButton.Visible = !colorButton.Visible;
            colorErrorLabel.Visible = false;
            colorBox.Checked = greenTextBox.Visible;
        }
    }
}
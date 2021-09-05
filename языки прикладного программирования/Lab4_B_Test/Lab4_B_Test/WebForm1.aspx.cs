using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Lab4_B_Test
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        private DropDownList[] lists;
        private string[] answers;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["start"] == null) {
                Session["start"] = DateTime.Now;
            }
            lists = new DropDownList[3] { capitalList, sumList, kiloList};
            answers = new string[3] {"Great Britain", "5", "Железо" };
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            int count = 0;
            for(int i = 0; i < lists.Length; i++) {
                if (lists[i].Text == answers[i]) {
                    count++;
                }
            }
            string mark = "";
            switch (count) {
                case 0: mark = "Плохо"; break;
                case 1: mark = "Плохо"; break;
                case 2: mark = "Хорошо"; break;
                case 3: mark = "Отлично"; break;
            }
            answersLabel.Text = "Ваша оценка: " + mark;
            timerLabel.Text = "C начала теста прошло: " + 
                (DateTime.Now - (DateTime) Session["start"]).Seconds.ToString() + " секунд";
        }
    }
}
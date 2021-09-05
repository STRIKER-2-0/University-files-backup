using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace RegisterForm
{
    public partial class RegistrationForm : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            ScriptManager.ScriptResourceMapping.AddDefinition("jquery", new ScriptResourceDefinition
            {
                Path = "~/scripts/jquery-1.7.2.min.js",

            });
        }

        protected void submitButton_Click(object sender, EventArgs e)
        {
            resultLabel.Text = (Page.IsValid && nameLabel.Text.Length <= 10  ?
                "successfully registered!" : "incorrect data!");
        }
    }
}
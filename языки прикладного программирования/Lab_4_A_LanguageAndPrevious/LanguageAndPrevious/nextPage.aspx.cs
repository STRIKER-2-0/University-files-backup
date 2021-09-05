using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PrevPage
{
    public partial class nextPage : System.Web.UI.Page
    {
        string previousPageUrl;
        string previousPageName;

        protected void Page_Load(object sender, EventArgs e)
        {
            String lang = Request.UserLanguages[0];
            if (lang.Contains("ru") || lang.Contains("RU"))
            {
                Label1.Text = "Вы используете русский язык системы";
            }
            else
            {
                Label1.Text = "You are using another language instead of russian.";
            }
            if (Request.UrlReferrer != null)
            {
                previousPageUrl = Request.UrlReferrer.AbsoluteUri;
                previousPageName = System.IO.Path.GetFileName(Request.UrlReferrer.AbsolutePath);
                HyperLink1.ID = "back";
                HyperLink1.Text = "<-Back";
                HyperLink1.NavigateUrl = previousPageUrl;
            }
            else
            {
                HyperLink1.Text = "No previous page";
            }
            
        }

       

       
    }
}
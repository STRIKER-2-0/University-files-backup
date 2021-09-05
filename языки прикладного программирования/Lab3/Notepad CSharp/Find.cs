using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Notepad_CSharp
{
    public partial class Find : Form
    {
        private Form2 activeForm;
        public Find(Form2 activeForm)
        {
            InitializeComponent();
            this.activeForm = activeForm;
        }

        private void okButton_Click(object sender, EventArgs e)
        {
            if (caseCheckBox.Checked && wordCheckBox.Checked)
            {
                activeForm.Find(textBox1.Text, RichTextBoxFinds.MatchCase | RichTextBoxFinds.WholeWord);
            }
            else if (caseCheckBox.Checked) {
                activeForm.Find(textBox1.Text, RichTextBoxFinds.MatchCase);
            }
            else if (wordCheckBox.Checked){
                activeForm.Find(textBox1.Text, RichTextBoxFinds.WholeWord);
            }
            else {
                activeForm.Find(textBox1.Text, RichTextBoxFinds.None);
            }        
            this.Dispose();
        }

        private void cancelButton_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }
    }
}

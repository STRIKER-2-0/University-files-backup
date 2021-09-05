using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Notepad_CSharp
{
    public partial class Form2 : Form
    {
        private bool saved = false;
        private ToolStripMenuItem item;
        public bool Saved { get => saved; set => saved = value; }
        public ToolStripMenuItem Item { get => item; set => item = value; }

        public Form2()
        {
            InitializeComponent();
            toolStripStatusLabel1.Text = "Amount of symbols ";
            toolStripStatusLabel2.Text = DateTime.Now.ToLongTimeString();
            toolStripStatusLabel2.ToolTipText = DateTime.Now.ToLongDateString();
        }
        public void Save(String filename)
        {
            if (filename.Substring(filename.Length - 4).Equals(".rtf"))
            {
                richTextBox1.SaveFile(filename);
            }
            else {
                StreamWriter writer = new StreamWriter(filename);
                writer.Write(richTextBox1.Text);
                writer.Close();
            }
            Saved = true;
        }
        public void Open(String filename) {
            if(filename.Substring(filename.Length - 4).Equals(".rtf"))
            {
                richTextBox1.LoadFile(filename);
            }
            else
            {
                StreamReader reader = new StreamReader(filename);
                richTextBox1.Text = reader.ReadToEnd();
                reader.Close();
            }
            Saved = true;
        }
        public void Cut() {
            richTextBox1.Cut();
        }
        public void Copy() {
            richTextBox1.Copy();
        }
        public void Paste() {
            richTextBox1.Paste();
        }
        public void Delete()
        {
            richTextBox1.SelectedText = "";
        }
        public void SelectAll()
        {
            richTextBox1.SelectAll();
        }
        public void Find(String text, RichTextBoxFinds options)
        {
            int from = richTextBox1.SelectionStart;
            int to = from + richTextBox1.SelectionLength;
            int start = richTextBox1.Find(text, from, to, options);
            if (start == -1) {
                return;
            }
            richTextBox1.Select(start, text.Length);
        }
        public void SetFont(Font font)
        {
            richTextBox1.SelectionFont = font;
        }
        public void SetColor(Color color)
        {
            richTextBox1.SelectionColor = color;
        }
        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {
            toolStripStatusLabel1.Text = "Amount of symbols " + richTextBox1.Text.Length;
        }

        private void Form2_FormClosing(object sender, FormClosingEventArgs e)
        {
            Form1 f1 = this.MdiParent as Form1;
            f1.removeItem(item);
        }
    }

    
}

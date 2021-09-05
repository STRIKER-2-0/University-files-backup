using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Notepad
{
    public partial class Form1 : Form
    {
        private int openDocuments = 0;
        private int selectedMode = 0;

        private List<ToolStripMenuItem> Items;
        public Form1()
        {
            InitializeComponent();
            Items = new List<ToolStripMenuItem>();
        }

        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f2 = new Form2();
            f2.Text = "untitled " + ++this.openDocuments;
            f2.MdiParent = this;
            ToolStripMenuItem tsmi = new ToolStripMenuItem(f2.Text);
            f2.Item = tsmi;
            this.arrangeIconToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] { tsmi });
            Items.Add(tsmi);
            this.selectedMode = Items.IndexOf(tsmi);
            tsmi.Click += new EventHandler(this.arrangeIconToolStripMenuItem_Click);
            f2.Show();
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if(saveFileDialog1.ShowDialog() == DialogResult.OK)
            {   
                Form2 form2 = new Form2();
                form2.MdiParent = this;
                form2.Save(saveFileDialog1.FileName);
            }
        }
        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                Form2 form2 = new Form2();
                form2.MdiParent = this; 
                form2.Text = openFileDialog1.FileName;
                form2.LoadF(openFileDialog1.FileName);
                ToolStripMenuItem tsmi = new ToolStripMenuItem(form2.Text);                    
                this.arrangeIconToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] { tsmi });
                Items.Add(tsmi);
                this.selectedMode = Items.IndexOf(tsmi);
                tsmi.Click += new EventHandler(this.arrangeIconToolStripMenuItem_Click);
                form2.Show();
            }
        }

        private void cascadeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.Cascade);
        }

        private void horizontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void verticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileVertical);
        }

        private void arrangeIconToolStripMenuItem_Click(object sender, EventArgs e)
        {   
            if (!(sender is ToolStripMenuItem))
                return;
            this.LayoutMdi(MdiLayout.ArrangeIcons);
            ToolStripMenuItem tsmi = sender as ToolStripMenuItem;
            this.selectedMode = Items.IndexOf(tsmi);
            Form[] forms = this.MdiChildren;
            foreach(Form form in forms)
            {
                if(form.Text == tsmi.Text)
                {
                    form.Activate();
                }
            }
        }

       

        private void toolStripButton4_Click(object sender, EventArgs e)
        {

        }

        private void fontToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (fontDialog1.ShowDialog() == DialogResult.OK)
            {
                Form2 form2 = this.ActiveMdiChild as Form2;
                form2.FontR(fontDialog1.Font);
            }
        }
        public void delItem(ToolStripMenuItem item)
        {
            Items.Remove(item);
            this.arrangeIconToolStripMenuItem.DropDownItems.Remove(item);
        }

        private void colorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (colorDialog1.ShowDialog() == DialogResult.OK)
            {
                Form2 form2 = this.ActiveMdiChild as Form2;
                form2.ColorR(colorDialog1.Color);
            }
        }

        private void arrangeIconToolStripMenuItem_MouseEnter(object sender, EventArgs e)
        {
            if (!(sender is ToolStripMenuItem))
                return;
            foreach (ToolStripMenuItem Item in (Items))
            {
                Item.Checked = this.selectedMode == Items.IndexOf(Item);
            }
        }
    }
}

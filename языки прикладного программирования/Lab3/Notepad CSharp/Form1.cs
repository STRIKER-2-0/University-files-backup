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
    public partial class Form1 : Form
    {
        private int childCount = 0;
        private ToolStripMenuItem nextIfDeleted;
        private ToolStripMenuItem previous;
        public Form1()
        {
            InitializeComponent();
        }

        public void removeItem(ToolStripMenuItem item) {
            this.arrangeIconsToolStripMenuItem.DropDownItems.Remove(item);
            if(nextIfDeleted != null)
                nextIfDeleted.Checked = true;
        }

        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 child = new Form2();
            child.MdiParent = this;
            childCount++;
            child.Text = "Untitled " + childCount;
            ToolStripMenuItem menuItem = new ToolStripMenuItem(child.Text);
            child.Item = menuItem;
            this.arrangeIconsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] { menuItem });
            if(previous != null) 
                previous.Checked = false;
            menuItem.Checked = true;
            nextIfDeleted = previous;
            previous = menuItem;
            menuItem.Click += new EventHandler(this.arrangeIconsToolStripMenuItem_Click);
            child.Show();
            child.WindowState = FormWindowState.Maximized;
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (openFileDialog1.ShowDialog() == DialogResult.OK)
            {
                String fileName = openFileDialog1.FileName;
                if (this.MdiChildren != null)
                {
                    foreach (Form form in this.MdiChildren)
                    {
                        if (form.Text == fileName)
                        {
                            form.Activate();
                            return;
                        }
                    }
                }
                Form2 child = new Form2();
                child.MdiParent = this;
                childCount++;
                child.Text = fileName;
                child.Open(fileName);
                ToolStripMenuItem menuItem = new ToolStripMenuItem(child.Text);
                child.Item = menuItem;
                this.arrangeIconsToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] { menuItem });
                if (previous != null)
                    previous.Checked = false;
                menuItem.Checked = true;
                nextIfDeleted = previous;
                previous = menuItem;
                menuItem.Click += new EventHandler(this.arrangeIconsToolStripMenuItem_Click);
                child.Show();               
            }
        }

        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null) { 
                Form2 child = this.ActiveMdiChild as Form2;
                if (child.Saved)
                {
                    child.Save(child.Text);
                }
                else
                {
                    if (saveFileDialog1.ShowDialog() == DialogResult.OK)
                    {
                        child.Save(saveFileDialog1.FileName);
                        child.Text = saveFileDialog1.FileName;
                    }
                }
            }
        }

        private void saveAsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                if (saveFileDialog1.ShowDialog() == DialogResult.OK)
                {
                    Form2 child = this.ActiveMdiChild as Form2;
                    child.Save(saveFileDialog1.FileName);
                    child.Text = saveFileDialog1.FileName;
                }
            }
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void cutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                Form2 child = this.ActiveMdiChild as Form2;
                child.Cut();
            }
        }

        private void copyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                Form2 child = this.ActiveMdiChild as Form2;
                child.Copy();
            }
        }

        private void pasteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                Form2 child = this.ActiveMdiChild as Form2;
                child.Paste();
            }
        }

        private void deleteToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                Form2 child = this.ActiveMdiChild as Form2;
                child.Delete();
            }
        }

        private void selectAllToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                Form2 child = this.ActiveMdiChild as Form2;
                child.SelectAll();
            }
        }

        private void findToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                Form2 child = this.ActiveMdiChild as Form2;
                Find findForm = new Find(child);
                findForm.Show();
            }
        }

        private void fontToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                if (fontDialog1.ShowDialog() == DialogResult.OK)
                {
                    Form2 child = this.ActiveMdiChild as Form2;
                    child.SetFont(fontDialog1.Font);
                }
            }
        }

        private void colorToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                if (colorDialog1.ShowDialog() == DialogResult.OK)
                {
                    Form2 child = this.ActiveMdiChild as Form2;
                    child.SetColor(colorDialog1.Color);
                }
            }
        }

        private void arrangeIconsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (this.ActiveMdiChild != null)
            {
                ToolStripMenuItem menuItem = sender as ToolStripMenuItem;
                if (previous != null)
                    previous.Checked = false;
                menuItem.Checked = true;
                nextIfDeleted = previous;
                previous = menuItem;
                foreach (Form form in this.MdiChildren)
                {
                    if (form.Text == menuItem.Text)
                    {
                        form.Activate();
                    }
                }
            }
        }

        private void cascadeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.Cascade);
        }

        private void tileHorizontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void tileVerticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.LayoutMdi(MdiLayout.TileVertical);
        }

        private void aboutProgramToolStripMenuItem_Click(object sender, EventArgs e)
        {
            About about = new About();
            about.Show();
        }
    }
}

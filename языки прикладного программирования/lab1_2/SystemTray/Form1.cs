using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace SystemTray
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void show()
        {
            this.ShowInTaskbar = true;
            WindowState = FormWindowState.Normal;
            showToolStripMenuItem.Enabled = false;
            hideToolStripMenuItem.Enabled = true;
        }

        private void hide()
        {
            this.ShowInTaskbar = false;
            WindowState = FormWindowState.Minimized;
            showToolStripMenuItem.Enabled = true;
            hideToolStripMenuItem.Enabled = false;
        }

        private void notifyIcon1_MouseDoubleClick(object sender, MouseEventArgs e)
        {
            show();
        }

        private void Form1_Resize(object sender, EventArgs e)
        {
            if (WindowState == FormWindowState.Minimized)
            {
                hide();
            }
        }

        private void showToolStripMenuItem_Click(object sender, EventArgs e)
        {
            show();
        }

        private void hideToolStripMenuItem_Click(object sender, EventArgs e)
        {
            hide();
        }

        
    }
}

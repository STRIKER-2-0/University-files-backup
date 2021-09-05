using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProgressBar
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            backgroundWorker1.DoWork += new DoWorkEventHandler(backgroundWorker1_DoWork);
            backgroundWorker1.RunWorkerCompleted += new RunWorkerCompletedEventHandler(backgroundWorker1_RunWorkerCompleted);
            backgroundWorker1.ProgressChanged += new ProgressChangedEventHandler(backgroundWorker1_ProgressChanged);
            backgroundWorker1.WorkerReportsProgress = true;
        }


        private void enterButton_Click(object sender, EventArgs e)
        {
            pictureBox1.Enabled = false;
            pictureBox1.Visible = false;
            try
            {
                progressBar1.Value = int.Parse(textBox1.Text);
            }
            catch (Exception)
            {
                MessageBox.Show("При выполнении преобразования типов возникла ошибка");
            }
        }

        private void pushButton_Click(object sender, EventArgs e)
        {            
            try
            {
                progressBar1.Value = textBox1.Text.Equals("") ? 0 : int.Parse(textBox1.Text);
            }
            catch (Exception)
            {                  
                MessageBox.Show("При выполнении преобразования типов возникла ошибка");
                return;
            }
            pictureBox1.Visible = true;
            pictureBox1.Enabled = true;
            if(!backgroundWorker1.IsBusy)
                backgroundWorker1.RunWorkerAsync();
        
        }

        private void backgroundWorker1_DoWork(object sender, DoWorkEventArgs e)
        {
            BackgroundWorker worker = sender as BackgroundWorker;

            for (int i = progressBar1.Value; i < progressBar1.Maximum; i++)
            {               
                    System.Threading.Thread.Sleep(50);
                    worker.ReportProgress(i);                
            }
        }

        private void backgroundWorker1_ProgressChanged(object sender, ProgressChangedEventArgs e)
        {
            progressBar1.PerformStep();
        }

        private void backgroundWorker1_RunWorkerCompleted(object sender, RunWorkerCompletedEventArgs e)
        {
            pictureBox1.Enabled = false;
            pictureBox1.Visible = false;
        }
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Runtime.InteropServices;

namespace AnimatedWindow
{
    public partial class Form1 : Form
    {
        [DllImportAttribute("user32.dll", EntryPoint = "AnimateWindow", SetLastError = true)]
        public static extern bool AnimateWindow(IntPtr hwnd, int dwTime, int dwFlags);
		/// <summary>
		/// Тип анимации окна. Перечисление возвращает тип данных int
		/// после приведения. Каждому элементу перечисления присвоено 
		/// свое значение типа int.
		/// </summary>	
		[Flags]
		public enum AnimateWindowFlags : int
		{
			AW_HOR_POSITIVE = 1,
			AW_HOR_NEGATIVE = 2,
			AW_VER_POSITIVE = 4,
			AW_VER_NEGATIVE = 8,
			AW_CENTER = 16,
			AW_HIDE = 65536,
			AW_ACTIVATE = 131072,
			AW_SLIDE = 262144,
			AW_BLEND = 524288
		};
		public Form1()
        {
            InitializeComponent();
        }

        private void appearButton_Click(object sender, EventArgs e)
        {
			this.Hide();
			AnimateWindow(this.Handle, 3000, (int) (AnimateWindowFlags.AW_ACTIVATE | AnimateWindowFlags.AW_BLEND));
		}

        private void horizontalButton_Click(object sender, EventArgs e)
        {
			this.Hide();
			AnimateWindow(this.Handle, 3000, (int) (AnimateWindowFlags.AW_ACTIVATE | AnimateWindowFlags.AW_HOR_POSITIVE));
		}

        private void centerButton_Click(object sender, EventArgs e)
        {
			this.Hide();
			AnimateWindow(this.Handle, 3000, (int) (AnimateWindowFlags.AW_ACTIVATE | AnimateWindowFlags.AW_CENTER));
		}
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MessageBox
{
    public partial class Form1 : Form
    {
		/// <summary>
		/// Вызов диалогового окна MessageBox.
		/// </summary>
		/// <param name="handle">Родительская форма окна</param>
		/// <param name="text">Текст окна.</param>
		/// <param name="title">Заголовок окна.</param>
		/// <param name="type">Тип окна.</param>		
		/// <returns></returns>
		[DllImport("user32.dll", CharSet = CharSet.Auto)]
		public static extern int MessageBox(IntPtr handle, string text, string title, uint type);
		/// <summary>
		/// Тип диалогового окна.
		/// </summary>
		public enum MessageBoxType : int
		{
			/// <summary>
			/// Три кнопки - Abort, Retry, Ignore
			/// </summary>
			MB_ABORTRETRYIGNORE = 2,
			/// <summary>
			/// Три кнопки - Cancel, Try, Continue
			/// </summary>
			MB_CANCELTRYCONTINUE = 6,
			/// <summary>
			/// Одна кнопка - Ok.
			/// </summary>
			MB_OK = 0,
			/// <summary>
			/// Две кнопки - Ok, Cancel.
			/// </summary>
			MB_OKCANCEL = 1,
			/// <summary>
			/// Две кнопки - Retry, Cancel
			/// </summary>
			MB_RETRYCANCEL = 5,
			/// <summary>
			/// Две кнопки - Yes, No
			/// </summary>
			MB_YESNO = 4,
			/// <summary>
			///  Три кнопки - Yes, No, Cancel
			/// </summary>
			MB_YESNOCANCEL = 3,
			/// <summary>
			/// Иконка - восклицание
			/// </summary>
			MB_ICONEXCLAMATION = 0x30,
			/// <summary>
			/// Иконка - предупреждение
			/// </summary>
			MB_ICONWARNING = 0x30,
			/// <summary>
			/// Иконка - информация
			/// </summary>
			MB_ICONINFORMATION = 0x40,
			/// <summary>
			/// Иконка - вопрос
			/// </summary>
			MB_ICONQUESTION = 0x20,
			/// <summary>
			/// Иконка - стоп
			/// </summary>
			MB_ICONSTOP = 0x10,
			/// <summary>
			/// Иконка - ошибка
			/// </summary>
			MB_ICONERROR = 0x10,

		}
		/// <summary>
		/// Тип возвращаемого значения.
		/// </summary>
		public enum MessageBoxReturnType : int
		{
			IDABORT = 3,
			IDCANCEL = 2,
			IDCONTINUE = 11,
			IDIGNORE = 5,
			IDNO = 7,
			IDOK = 1,
			IDRETRY = 4,
			IDTRYAGAIN = 10,
			IDYES = 6
		}
		public Form1()
        {
            InitializeComponent();
        }
		private string text = "Hello world";
		private string title = "From WinApi";
		private void interruptButton_Click(object sender, EventArgs e)
        {			
			MessageBox(IntPtr.Zero, text, title, (uint) (MessageBoxType.MB_ABORTRETRYIGNORE | MessageBoxType.MB_ICONQUESTION));
		}

        private void yesNoCancelButton_Click(object sender, EventArgs e)
        {
			MessageBox(IntPtr.Zero, text, title, (uint)(MessageBoxType.MB_YESNOCANCEL | MessageBoxType.MB_ICONINFORMATION));
		}

        private void OKButton_Click(object sender, EventArgs e)
        {
			MessageBox(IntPtr.Zero, text, title, (uint)(MessageBoxType.MB_OK | MessageBoxType.MB_ICONSTOP));
		}

        private void yesNoButton_Click(object sender, EventArgs e)
        {
			MessageBox(IntPtr.Zero, text, title, (uint)(MessageBoxType.MB_YESNO | MessageBoxType.MB_ICONWARNING));
		}
    }
}

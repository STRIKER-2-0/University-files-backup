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

namespace GetUserName
{
    public partial class Form1 : Form
    {
		/// <summary>
		/// Получение имени текущего пользователя.
		/// </summary>
		/// <param name="nameFormat">Формат имени из перечисления NameFormat.</param>
		/// <param name="userName">Выходной параметр - имя.пользователя</param>
		/// <param name="userNameSize">Количество символов в имени.</param>
		/// <returns></returns>
		[DllImport("secur32.dll", CharSet = CharSet.Auto)]
		public static extern int GetUserNameEx(int nameFormat, StringBuilder userName, ref uint userNameSize);

		/// <summary>
		/// Формат имени.
		/// </summary>
		public enum NameFormat : int
		{
			NameUnknown = 0,
			NameFullyQualifiedDN = 1,
			NameSamCompatible = 2,
			NameDisplay = 3,
			NameUniqueId = 6,
			NameCanonical = 7,
			NameUserPrincipal = 8,
			NameCanonicalEx = 9,
			NameServicePrincipal = 10,
			NameDnsDomain = 12
		};
		public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
			uint size = 150;
			StringBuilder sb = new StringBuilder((int) size);			
			GetUserNameEx(2, sb, ref size);
			label1.Text = "Имя пользователя: " + sb.ToString();
		}
    }
}

using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ScreenShot
{
    public partial class Form1 : Form
    {
		/// <summary>
		/// Возвращение  указателя на рабочий стол.
		/// </summary>
		/// <returns></returns>
		[DllImport("User32.dll")]
		public static extern int GetDesktopWindow();
		/// <summary>
		/// Получение структуры данных.
		/// </summary>
		/// <param name="hWnd">Указатель на окно.</param>
		/// <returns></returns>
		[DllImport("User32.dll")]
		public static extern int GetWindowDC(int hWnd);
		/// <summary>
		/// Освобождение  структуры данных.
		/// </summary>
		/// <param name="hWnd">Указатель на окно.</param>
		/// <param name="hDC">Указатель на структуру данных.</param>
		/// <returns></returns>
		[DllImport("User32.dll")]
		public static extern int ReleaseDC(int hWnd, int hDC);

		/// <summary>
		/// Передача изображения.
		/// </summary>
		/// <param name="hdcDest">Указатель на назначение передачи.</param>
		/// <param name="nXDest">Х координата верхнего левого угла назначения.</param>
		/// <param name="nYDest">У координата верхнего левого угла назначения.</param>
		/// <param name="nWidth">Ширина прямоугольника.</param>
		/// <param name="nHeight">Высота прямоугольника.</param>
		/// <param name="hdcSrc">Указатель на источник.</param>
		/// <param name="nXSrc">Х координата верхнего левого угла источника.</param>
		/// <param name="nYSrc">У координата верхнего левого угла источника.</param>
		/// <param name="dwRop">Код растровой операции.</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern bool BitBlt(int hdcDest, int nXDest, int nYDest, int nWidth, int nHeight, int hdcSrc,
			int nXSrc, int nYSrc, int dwRop);
		/// <summary>
		/// Создание  и запись в структуру данных изображения.
		/// </summary>
		/// <param name="hdc">Указатель на структуру данных.</param>
		/// <param name="nWidth">Ширина изображения.</param>
		/// <param name="nHeight">Высота изображения.</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern int CreateCompatibleBitmap(int hdc, int nWidth, int nHeight);
		/// <summary>
		/// Создание и сохранение  в памяти структуры данных, совместимую с указанным устройством вывода.
		/// Для помещения  изображение в структуру данных 
		/// необходимо указать высоту, ширину и цветовой  режим  изображения. 
		/// Это можно сделать с помощью функции CreateCompatibleBitmap, поддерживаемой устройствами с растровым выводом. 
		/// Для получения информации об этих устройствах используется функция GetDeviceCaps. 
		/// После использования структуры данных ее нужно удалить с помощью функции DeleteDC.
		/// </summary>
		/// <param name="hdc">Указатель на существующую структуру данных. Если указатель равен null,
		/// то функция создает  структуру для экрана текущего приложения.</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern int CreateCompatibleDC(int hdc);
		/// <summary>
		/// Удаление  указанной структуры данных.
		/// </summary>
		/// <param name="hdc">Структура данных.</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern bool DeleteDC(int hdc);
		/// <summary>
		/// Удаление графических объектов освобождением системных ресурсов.
		/// </summary>
		/// <param name="hObject">Указатель на графический объект.</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern bool DeleteObject(int hObject);
		/// <summary>
		/// Возвращение  информации о указанной структуре.
		/// </summary>
		/// <param name="hdc">Указатель на структуру данных.</param>
		/// <param name="nIndex">Индекс совместимости. .</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern int GetDeviceCaps(int hdc, int nIndex);
		/// <summary>
		/// Выбор объекта, находящегося в указанной структуре данных.
		/// </summary>
		/// <param name="hdc">Указатель на структуру данных.</param>
		/// <param name="hgdiobj">Указатель на объект.</param>
		/// <returns></returns>
		[DllImport("GDI32.dll")]
		public static extern int SelectObject(int hdc, int hgdiobj);
		public Form1()
        {
            InitializeComponent();
        }
		public new void Hide()
        {
			base.Hide();
			Thread.Sleep(500);
        }
        private void button1_Click(object sender, EventArgs e)
        {
			this.Hide();
			
			int window = GetDesktopWindow();
			int source = GetWindowDC(window);
			int compatStruct = CreateCompatibleDC(source);
			int height = GetDeviceCaps(source, 10);
			int widht = GetDeviceCaps(source, 8);
			int bitmap = CreateCompatibleBitmap(source, widht, height);
			SelectObject(compatStruct, bitmap);
			BitBlt(compatStruct, 0, 0, widht, height, source, 0, 0, 0x00CC0020);
			SaveFileDialog saveFileDialog = new SaveFileDialog();
			saveFileDialog.Filter = "Файлы jpg|*.jpg";

			if (saveFileDialog.ShowDialog() != DialogResult.OK)
				return;
			Image image = Image.FromHbitmap(new IntPtr(bitmap));
			new Bitmap(image, image.Width, image.Height).Save(saveFileDialog.FileName, ImageFormat.Jpeg);
			this.Show();
		}
	}
}

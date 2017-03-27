package fr.iutinfo.skeleton.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import fr.iutinfo.skeleton.api.BDDFactory;
import fr.iutinfo.skeleton.api.Image;
import fr.iutinfo.skeleton.api.ImageDAO;

public class Hello extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String simpleParam = getServletConfig().getInitParameter("simpleParam");
		out.println("Hello World " + simpleParam);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}

		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {

				return;
			}

			while (it.hasNext()) {

				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {

				} else {

					File file = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")
							+ fileItem.getName());

					fileItem.write(file);

					ImageDAO dao = BDDFactory.getDbi().open(ImageDAO.class);

					Image image = new Image();
					image.setDesc("desc");
					image.setTitle("title");
					image.setUrl(file.getPath());
					dao.insert(image);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("gallery.html");
	}

}
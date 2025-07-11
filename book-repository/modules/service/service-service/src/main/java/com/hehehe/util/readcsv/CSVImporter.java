package com.hehehe.util.readcsv;

import com.hehehe.servicebuilder.model.Author;
import com.hehehe.servicebuilder.model.Book;
import com.hehehe.servicebuilder.model.Category;
import com.hehehe.servicebuilder.model.Subtitle;
import com.hehehe.servicebuilder.model.impl.BookImpl;
import com.hehehe.servicebuilder.model.impl.CategoryImpl;
import com.hehehe.servicebuilder.model.impl.SubtitleImpl;
import com.hehehe.servicebuilder.service.BookLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.osgi.web.servlet.context.helper.order.Order.Path;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;

@Component(immediate = true)
public class CSVImporter {

    private static final Log _log = LogFactoryUtil.getLog(CSVImporter.class);

//    @Activate
//    public void activate() {
//    	Path filePath = Paths.get("E:\\Tools\\data\\authors.csv");
//    	Reader reader = Files.newBufferedReader(filePath);
//    	CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
//
//    	for (CSVRecord record : parser) {
//    	    String name = record.get("name").trim();
//    	    
//    	    // Kiểm tra trùng trước khi thêm
//    	    Author existing = AuthorLocalServiceUtil.fetchByName(name);
//    	    if (existing == null) {
//    	        long id = CounterLocalServiceUtil.increment();
//    	        Author author = AuthorLocalServiceUtil.createAuthor(id);
//    	        author.setName(name);
//    	        AuthorLocalServiceUtil.addAuthor(author);
//    	    }
//    	}
//    }
}
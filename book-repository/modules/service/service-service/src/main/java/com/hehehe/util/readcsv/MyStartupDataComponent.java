package com.hehehe.util.readcsv;

import com.hehehe.servicebuilder.service.AuthorLocalService;
import com.hehehe.servicebuilder.service.BookLocalService;
import com.hehehe.servicebuilder.service.CategoryLocalService;
import com.hehehe.servicebuilder.service.SubtitleLocalService;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = MyStartupDataComponent.class)
public class MyStartupDataComponent {
	@Reference
	AuthorLocalService authorLocalService;
	@Reference
	SubtitleLocalService subtitleLocalService;
	@Reference 
	CategoryLocalService categoryLocalService;
	@Reference
	BookLocalService bookLocalService;
	@Activate
    public void activate() {
//		if(authorLocalService.getAuthorsCount() < 100) {
//			 try (InputStream author = load("author_clean.csv")) {
//		            if (author == null) {
//		                System.out.println("Không tìm thấy file");
//		            } else {
//		            	try (BufferedReader reader = new BufferedReader(new InputStreamReader(author))) {
//			                String line;
//			                boolean isFirstLine = true;
//			                while ((line = reader.readLine()) != null) {
//			                    if (isFirstLine) {
//			                        isFirstLine = false; // Bỏ dòng header
//			                        continue;
//			                    }
//			                    authorLocalService.addAuthor(line.trim());
//			                }
//			            }
//		            }
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		        }
//		} else {
//			System.out.println("author success!");
//		}
//		if(categoryLocalService.getCategoriesCount() < 50) {
//			 try (InputStream author = load("categories.csv")) {
//		            if (author == null) {
//		                System.out.println("Không tìm thấy file");
//		            } else {
//		            	try (BufferedReader reader = new BufferedReader(new InputStreamReader(author))) {
//			                String line;
//			                boolean isFirstLine = true;
//			                while ((line = reader.readLine()) != null) {
//			                    if (isFirstLine) {
//			                        isFirstLine = false; // Bỏ dòng header
//			                        continue;
//			                    }
//			                    categoryLocalService.addCategory(line.trim());
//			                }
//			            }
//		            }
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		        }
//		} else {
//			System.out.println("category success!");
//		}
//		if(subtitleLocalService.getSubtitlesCount() < 20) {
//			 try (InputStream author = load("subtitles.csv")) {
//		            if (author == null) {
//		                System.out.println("Không tìm thấy file");
//		            } else {
//		            	try (BufferedReader reader = new BufferedReader(new InputStreamReader(author))) {
//			                String line;
//			                boolean isFirstLine = true;
//			                while ((line = reader.readLine()) != null) {
//			                    if (isFirstLine) {
//			                        isFirstLine = false; // Bỏ dòng header
//			                        continue;
//			                    }
//			                    subtitleLocalService.addSubtitle(line.trim());
//			                }
//			            }
//		            }
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		        }
//		} else {
//			System.out.println("subtitle success!");
//		}
//		if(bookLocalService.getBooksCount() < 100) {
//			 try (InputStream author = load("books_cleaned.csv")) {
//		            if (author == null) {
//		                System.out.println("Không tìm thấy file");
//		            } else {
//		            	try (InputStream is = load("books_cleaned.csv");
//		            		    InputStreamReader reader = new InputStreamReader(is);
//								CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
//
//		            		    for (CSVRecord record : parser) {
//		            		        String title = record.get("title").trim();
//		            		        String subtitle = record.get("subtitle").trim();
//		            		        String rawAuthors = record.get("authors").trim();
//		            		        List<String> authors = Arrays.stream(rawAuthors.split(";"))
//		                                    .map(String::trim)       
//		                                    .filter(s -> !s.isEmpty()) 
//		                                    .collect(Collectors.toList());
//		            		        String categories = record.get("categories").trim();
//		            		        String thumbnail = record.get("thumbnail").trim();
//		            		        String description = record.get("description").trim();
//		            		        int publishedYear = (int) Double.parseDouble(record.get("published_year").trim());
//		            		        int numPages = (int) Double.parseDouble(record.get("num_pages").trim());
//		            		        int price = (int) Double.parseDouble(record.get("price").trim());
//		            		        int stock = (int) Double.parseDouble(record.get("stock").trim());
//		            		        bookLocalService.addBook(authorLocalService.getAuthorIdsByNames(authors), title, description, thumbnail, subtitleLocalService.getSubtitleIdByName(subtitle), categoryLocalService.getCategoryIdByName(categories), price, stock, numPages, publishedYear);
//		            		    }
//
//		            		} catch (Exception e) {
//		            		    e.printStackTrace();
//		            		}
//		            }
//		        } catch (Exception e) {
//		        	System.err.println("Book FAILED");
//		            e.printStackTrace();
//		        }
//		} else {
//			System.out.println("book success!");
//		}
//    }
	}
    public InputStream load(String relativePath) {
        // Mặc định root là META-INF/resources
        String fullPath = "META-INF/resources/" + relativePath;
        return getClass().getClassLoader().getResourceAsStream(fullPath);
    }
}

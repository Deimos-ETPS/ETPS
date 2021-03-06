//package com.etps.etps.controllers;
//
//import com.etps.etps.excelConversions.ReadFromExcel;
//import com.etps.etps.excelConversions.StatusChange;
//import com.etps.etps.excelConversions.WriteToExcel;
//import com.etps.etps.models.DaoCombiner;
//import com.etps.etps.models.User;
//import com.etps.etps.repositories.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Map;
//
//@Controller
//public class testController {
//    private Users userDao;
//    private Providers providerDao;
//    private Campuses campusDao;
//    private Programs programDao;
//    private Submissions submissionDao;
//
//    public testController(Users userDao, Providers providerDao, Campuses campusDao, Programs programDao, Submissions submissionDao) {
//        this.userDao = userDao;
//        this.providerDao = providerDao;
//        this.campusDao = campusDao;
//        this.programDao = programDao;
//        this.submissionDao = submissionDao;
//    }
//
//
//
//    @GetMapping("/test")
//    public String testShow() {
//        return "testPage";
//    }
//
//    @PostMapping("/test/write/{fileName:.+}")
//    public String WriteTest(HttpServletRequest request,
//                            HttpServletResponse response,
//                            @PathVariable("fileName") String fileName) {
//
////        String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
////        Path file = Paths.get(dataDirectory, fileName);
////        if (Files.exists(file))
////        {
////            response.setContentType("application/pdf");
////            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
////            try
////            {
////                Files.copy(file, response.getOutputStream());
////                response.getOutputStream().flush();
////            }
////            catch (IOException ex) {
////                ex.printStackTrace();
////            }
////        }
//
//
//
//        DaoCombiner daoCombiner = new DaoCombiner(userDao,providerDao,campusDao,programDao);
//
//        WriteToExcel writeToExcel = new WriteToExcel(providerDao,campusDao,programDao,submissionDao);
//
//        String home = System.getProperty("user.home");
//
//        User user = userDao.findByUserProviderId(802);
//        File file = new File(home+"/Downloads/ETPS_"+user.getUserProviderId()+"_All.xlsx");
//
//
//        Map<String, Object[]> testdata = writeToExcel.GenerateAllUserData(user);
////        File file = new File("testwrite1.xlsx");
//        writeToExcel.WriteExcel(testdata, file);
//
//        user = userDao.findByUserProviderId(1);
//        testdata = writeToExcel.GenerateAllUserData(user);
//        file = new File(home+"/Downloads/ETPS_data_All.xlsx");
//        writeToExcel.WriteExcel(testdata, file);
//
//
//        user = userDao.findByUserProviderId(900);
//        file = new File(home+"/Downloads/ETPS_"+user.getUserProviderId()+"_Pending.xlsx");
//        testdata = writeToExcel.GenerateByStatus(user,"pending");
//        writeToExcel.WriteExcel(testdata, file);
//
//        user = userDao.findByUserProviderId(1);
//        file = new File(home+"/Downloads/ETPS_All_Pending.xlsx");
//        testdata = writeToExcel.GenerateByStatus(user,"pending");
//        writeToExcel.WriteExcel(testdata, file);
//
//        user = userDao.findByUserProviderId(900);
//        file = new File(home+"/Downloads/ETPS_"+user.getUserProviderId()+"_Approved.xlsx");
//        testdata = writeToExcel.GenerateByStatus(user,"approved");
//        writeToExcel.WriteExcel(testdata, file);
//
//        user = userDao.findByUserProviderId(1);
//        file = new File(home+"/Downloads/ETPS_All_Approved.xlsx");
//        testdata = writeToExcel.GenerateByStatus(user,"approved");
//        writeToExcel.WriteExcel(testdata, file);
//
//        user = userDao.findByUserProviderId(900);
//        file = new File(home+"/Downloads/ETPS_"+user.getUserProviderId()+"_Expired.xlsx");
//        testdata = writeToExcel.GenerateByStatus(user,"expired");
//        writeToExcel.WriteExcel(testdata, file);
//
//        user = userDao.findByUserProviderId(1);
//        file = new File(home+"/Downloads/ETPS_All_Expired.xlsx");
//        testdata = writeToExcel.GenerateByStatus(user,"expired");
//        writeToExcel.WriteExcel(testdata, file);
//
//
//
//
//
//        return "redirect:/test";
//    }
//
//    @PostMapping("test/read")
//    public String ReadTest(@RequestParam("readFile") File file) {
//
//        DaoCombiner daoCombiner = new DaoCombiner(userDao,providerDao,campusDao,programDao);
//
//        File newFile = new File(file.getAbsolutePath());
//        System.out.println(file.getAbsolutePath());
//
//        ReadFromExcel readFromExcel = new ReadFromExcel(providerDao, campusDao, programDao, submissionDao);
////        File file = new File("/Users/robertlr/IdeaProjects/etps/testread1.xlsx");
////        readFromExcel.ReadExcel(file);
////        readFromExcel.ReadExcel(pathTest);
//        User user = userDao.findByUserProviderId(900);
////        readFromExcel.ReadExcel(newFile,user);
//        return "redirect:/test";
//    }
//
//
//    @PostMapping("test/approve")
//    public String approveTest(){
//        User user = userDao.findByUserProviderId(900);
//        StatusChange statusChange = new StatusChange(submissionDao,providerDao);
//        statusChange.ApproveSubmission(user);
//        return "redirect:/test";
//    }
//
//}

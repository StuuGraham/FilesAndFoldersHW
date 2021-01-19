package com.example.FilesAndFolders.components;

import com.example.FilesAndFolders.models.File;
import com.example.FilesAndFolders.models.Folder;
import com.example.FilesAndFolders.models.User;
import com.example.FilesAndFolders.repositories.FileRepository;
import com.example.FilesAndFolders.repositories.FolderRepository;
import com.example.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;
    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User john = new User("John");
        userRepository.save(john);

        User roosa = new User("Roosa");
        userRepository.save(roosa);

        User juan = new User("Juan");
        userRepository.save(juan);

        User zsolt = new User("Zsolt");
        userRepository.save(zsolt);

        Folder pythonProjects = new Folder("Python Projects", john);
        folderRepository.save(pythonProjects);

        Folder javascriptProjects = new Folder("JavaScript Projects", roosa);
        folderRepository.save(javascriptProjects);

        Folder javaProjects = new Folder("Java Projects", zsolt);
        folderRepository.save(javaProjects);

        Folder reactProjects = new Folder("React Projects", juan);
        folderRepository.save(reactProjects);

        File busLab = new File("Bus Lab", ".py", 100, pythonProjects);
        fileRepository.save(busLab);

        File karaokeLab = new File("Karaoke Lab", ".js", 200, javascriptProjects);
        fileRepository.save(karaokeLab);

        File fantasyLab = new File("Fantasy Lab", ".java", 5000000, javaProjects);
        fileRepository.save(fantasyLab);

        File pubLab = new File("Pub Lab", ".jsx", 250, reactProjects);
        fileRepository.save(pubLab);
    }
}

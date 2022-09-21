package com.curso.ecommerce.controller;

import com.curso.ecommerce.model.Alimento;
import com.curso.ecommerce.model.Usuario;
import com.curso.ecommerce.service.AlimentoService;
import com.curso.ecommerce.service.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/alimento")
public class AlimentoController {

    private final Logger LOGGER = LoggerFactory.getLogger(AlimentoController.class);

    @Autowired
    private UploadFileService upload;

    @Autowired
    private AlimentoService alimentoService;

    //Este metodo es el que muestra los alimnetos disponibles en la vista principal
    @GetMapping("")
    public String show(Model model){
        model.addAttribute("alimentos",alimentoService.findAll());
        return "alimento/show";
    }


    //este metodo permite crear nuevos alimentos y el metodo que sigue los guarda en la base de datos
    @GetMapping("/create")
    public String create(){
        return "alimento/create";
    }


    //Este metodo guarda el dato en la base de datos
    @PostMapping("/save")
    public String save(Alimento alimento, @RequestParam("img") MultipartFile file) throws IOException {
        //El LOGGER muestra el alimento en la consola de aquí de intelij sin necesidad de ir a la base de datos
        LOGGER.info("este es el alimento {}",alimento);
        Usuario u = new Usuario(1,"","","","","","","");
        alimento.setUsuario(u);

        //imagen
        if(alimento.getId()==null){ // Cuando se crea un alimento
            String nombreImagen = upload.saveImage(file);
            alimento.setImagen(nombreImagen);
        }else{
        }
        alimentoService.save(alimento);
        return "redirect:/alimento";
    }


    //Aquí se edita el alimento por medio de su respectivo id
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        Alimento alimento = new Alimento();
        Optional<Alimento> optionalAlimento = alimentoService.get(id);
        alimento=optionalAlimento.get();

        //El LOGGER muestra el alimento en la consola de aquí de intelij sin necesidad de ir a la base de datos
        LOGGER.info("Alimento encontrado: {}",alimento);
        model.addAttribute("alimento",alimento);
        return "alimento/edit";
    }


    // Aquí se actualiza el alimento
    @PostMapping("/update")
    public String update(Alimento alimento,@RequestParam("img") MultipartFile file) throws IOException {

        Alimento a = new Alimento();
        a= alimentoService.get(alimento.getId()).get();

        if(file.isEmpty()){ //Cuando se edita el alimento pero no se le cambia la imagen

            alimento.setImagen(a.getImagen());
        }else{ //Se edita la imagen junto con el alimento

            // se elimina la imagen cuando no sea la imagen por default
            if(a.getImagen().equals("default")){
                upload.deleteImage(a.getImagen());
            }

            String nombreImagen = upload.saveImage(file);
            alimento.setImagen(nombreImagen);
        }
        alimento.setUsuario(a.getUsuario());
        alimentoService.update(alimento);
        return "redirect:/alimento";
    }


    //Aqui se elimina el alimento y tambien su respectiva imagen
    @GetMapping ("/delete/{id}")
    public String delete(@PathVariable Integer id){
        Alimento a = new Alimento();
        a= alimentoService.get(id).get();

        // se elimina la imagen cuando no sea la imagen por default
        if(a.getImagen().equals("default")){
            upload.deleteImage(a.getImagen());
        }
        alimentoService.delete(id);
        return "redirect:/alimento";
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.port.EAG.Controller;

import com.port.EAG.Dto.dtoPersona;
import com.port.EAG.Entity.Persona;
import com.port.EAG.Security.Controller.Mensaje;
import com.port.EAG.Service.ImpPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/personas")
@CrossOrigin(origins ={ "http://localhost:4200", "https://abiguzap.web.app"})
public class PersonaController {
    
    @Autowired
    ImpPersonaService personaService;
     

@GetMapping("/lista")
public ResponseEntity<List<Persona>> list(){
    List<Persona> list = personaService.list();
    return new ResponseEntity(list, HttpStatus.OK);
}

  @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!personaService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
    }
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    
    /*@DeleteMapping("/delete/{id}")
public ResponseEntity<?> delete(@PathVariable("id") int id){
if(!personaService.existsById(id)){
    return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
}
personaService.delete(id);
return new ResponseEntity(new Mensaje("Experiencia Eliminada"),HttpStatus.OK);
}

@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
    
    if(StringUtils.isBlank(dtoexp.getNombre()))
        return new ResponseEntity(new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    
    
    if(sExperiencia.existsByNombre(dtoexp.getNombre())){
        return new ResponseEntity (new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
    }
    Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), dtoexp.getDescripcionE());
    
    sExperiencia.save(experiencia);
    return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
}*/

@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
   //Validamos si existe id// 
 if(!personaService.existsById(id)){
     return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.NOT_FOUND);
 }
 if(personaService.existsByNombre(dtopersona.getNombre()) && personaService.getByNombre(dtopersona.getNombre()).get().getId() != id){
return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
 }
 if(StringUtils.isBlank(dtopersona.getNombre())){
     return new ResponseEntity (new Mensaje ("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
 }
 Persona persona = personaService.getOne(id).get();
 
 persona.setNombre(dtopersona.getNombre());
 persona.setApellido(dtopersona.getApellido());
 persona.setImg(dtopersona.getImg());
persona.setDescripcion(dtopersona.getDescripcion());
 
 personaService.save(persona);
 return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
     }

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*@GetMapping("/traer")
    public List<Persona> getPersona(){
        return ipersonaService.getPersona();
    }
    @PostMapping("/crear")
    public String crearPersona(@RequestBody Persona persona){
        ipersonaService.savePersona(persona);
        return "la persona fue creada correctamente";
    }
    @DeleteMapping("/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        ipersonaService.deletePersona(id);
        return "la persona fue eliminada correctamente";
    }

    @PutMapping("/editar/{id}")
     public Persona editPersona(@PathVariable Long id,
                                @RequestParam("nombre") String nuevoNombre,
                                @RequestParam("apellido") String nuevoApellido,
                                @RequestParam("img") String nuevoImg){
          Persona persona = ipersonaService.findPersona(id);
         
         persona.setNombre(nuevoNombre);
         persona.setApellido(nuevoApellido);
         persona.setImg(nuevoImg);
         
         ipersonaService.savePersona(persona);
         return persona;
     }
     @GetMapping("/traer/perfil")
     public Persona findPersona(){
         return ipersonaService.findPersona((long)1);
     }*/
             }

##Pasos para configurar la seguridad

Al crear una clase SecurityConfig, cuando se llama al metodo authenticationEntryPoint()se debe llamar otra clase que debe heredar de la clase AuthenticationEntryPoint la cual el metodo commerce
crea el tipo de manejo cuando no se puede acceder a los recursos, para este caso se coloca como inautorizado.

##Manejar las sesiones desde el controlador
Despues de configuar SecurityConfig, se deben manejar las sesiones en el controllador por lo que se debe crear la clase Autentication:
 Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));
 
 Donde data almacena la informacion de inicio de sesion, luegose llama a
 SecurityContextHolder.getContext().setAuthentication(authentication);
 
 para establecer un usuario activo por lo que comprendo
 
##Crear una clase CustomUserDetailsService que implementa UserDetailsService

Se debe heredar el metodo LoadUserByUsername y cear otro metodo para trabajar con los roles. trabajo con el metodo LoadByUserName donde uso el repositorio de User.

##Incomporar la clase CustomDetaisService a la clase SecurityConfig
crear el autowired de UserDetailsService, luego se implementa un metodo heredado    configure con paraemtro AuthenticationManagerBuilder 
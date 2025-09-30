# README Técnico – Protocolo Colaborativo U2

Este documento describe la organización de carpetas y componentes de la aplicación desarrollada para el CEA de procesos publicitarios en radio. La implementación sigue los principios de **arquitectura hexagonal**, separando dominio, aplicación e infraestructura.  

El código está escrito en **Java estándar**, sin dependencias de frameworks, garantizando la independencia del dominio frente a la infraestructura y facilitando la mantenibilidad.

---

## 📂 Estructura del proyecto

```
src
 ├── main
 │   └── java
 │       ├── application         -> Casos de uso, DTOs y mapeadores
 │       │    ├── dto
 │       │    │   └── ContratoDTO.java
 │       │    ├── mappers
 │       │    │   └── ContratoMapper.java
 │       │    └── usecases
 │       │        ├── ContratoRepository.java
 │       │        └── RegistrarContratoUseCase.java
 │       │
 │       ├── domain              -> Capa de dominio (reglas de negocio puras)
 │       │    ├── contratos      -> Entidades y agregados (Contrato, Patrocinador, Duracion, Importe)
 │       │    ├── emisoras       -> Entidades y VO relacionados (Emisora, FranjaHoraria, Programa)
 │       │    ├── eventos        -> Eventos de dominio (ContratoDePublicidadCreado, PublicidadAsignadaAPrograma)
 │       │    ├── excepciones    -> Excepciones específicas (ContratoVencidoException, DomainException)
 │       │    ├── servicios      -> Servicios de dominio y estrategias (Strategy, Domain Service)
 │       │    └── specification  -> Implementación del patrón Specification
 │       │
 │       └── infrastructure      -> Adaptadores de entrada y salida
 │            ├── adapters
 │            │   ├── in         -> Servicios de aplicación (RegistrarContratoService)
 │            │   └── out        -> Implementaciones de repositorios (ContratoRepositoryInMemory)
 │
 └── test
     └── java
         ├── application
         │    └── usecases
         │         └── RegistrarContratoUseCaseTest.java
         │
         └── domain
              └── contratos
                   ├── ContratoTest.java
                   ├── DuracionTest.java
                   └── ServicioCalculoPublicidadTest.java
```

---

## 🧩 Descripción por capas

### Dominio
- Define las **entidades** principales (`Contrato`, `Patrocinador`, `Emisora`), los **Value Objects** (`Duracion`, `Importe`, `FranjaHoraria`) y los **agregados**.  
- Contiene las **reglas de negocio puras**.  
- Incluye servicios como `PoliticaTarifaNormal` y `ServicioCalculoPublicidad`.  
- Aplica patrones: Factory Method, Strategy, Specification y Domain Service.  

### Aplicación
- Implementa **casos de uso** (`RegistrarContratoUseCase`).  
- Define **DTOs** y **mappers** (`ContratoDTO`, `ContratoMapper`) para comunicar el dominio con otras capas.  
- Depende del dominio, pero nunca al revés.  

### Infraestructura
- Contiene **adaptadores** de entrada (ej. `RegistrarContratoService`) y salida (ej. `ContratoRepositoryInMemory`).  
- Permite cambiar fácilmente tecnologías externas (repositorios, servicios, UI) sin modificar el dominio.  

### Tests
- Pruebas unitarias para entidades, servicios y casos de uso.  
- Ejemplos:  
  - `ContratoTest` asegura que los contratos se creen y validen correctamente.  
  - `DuracionTest` valida las reglas de duración.  
  - `ServicioCalculoPublicidadTest` prueba la lógica de cálculo de tarifas.  
  - `RegistrarContratoUseCaseTest` comprueba el flujo completo del caso de uso.  

---

## ✅ Independencia de frameworks
El dominio está implementado en Java puro, sin dependencias de frameworks como Spring o JPA. Esto asegura que:
- El dominio se pueda probar de manera aislada.  
- La infraestructura se pueda sustituir sin modificar reglas de negocio.  
- El sistema sea fácilmente extensible.  

---

## 📌 Patrones de diseño aplicados
- **Factory Method**: en `Contrato` para crear instancias válidas.  
- **Strategy**: en políticas de cálculo de tarifas (`PoliticaCalculoTarifa`, `PoliticaTarifaNormal`, `PoliticaTarifaDescuento`).  
- **Specification**: validación de franjas horarias con `FranjaHorariaDisponibleSpecification`.  
- **Domain Service**: coordinación de reglas que involucran varias entidades (`ServicioCalculoPublicidad`).  

---

## 🚀 Cómo ejecutar
1. Compilar el proyecto desde la raíz:  
   ```bash
   javac -d out src/main/java/**/*.java
   ```
2. Ejecutar la clase principal:  
   ```bash
   java -cp out Main
   ```
3. Para correr los tests, utilizar un framework de testing compatible con JUnit (los tests están en `src/test/java`).  

---

## 📖 Guía rápida
- Revisa primero las entidades en `domain/contratos` y `domain/emisoras`.  
- Luego analiza los Value Objects (`Duracion`, `Importe`, `FranjaHoraria`).  
- Explora los servicios de dominio y especificaciones para entender las reglas transversales.  
- Finalmente, consulta los casos de uso en `application/usecases` para ver cómo se orquesta el dominio desde la aplicación.  

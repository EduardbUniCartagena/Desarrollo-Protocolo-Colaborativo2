# README Técnico – Protocolo Colaborativo U2 (Versión Final)

Este documento describe la arquitectura y organización del **Sistema de Gestión de Procesos Publicitarios en Radio**. La implementación sigue estrictamente los principios de **Arquitectura Hexagonal** (Puertos y Adaptadores), garantizando la separación de preocupaciones entre la lógica de negocio, la interfaz de usuario y la persistencia de datos.

El proyecto ha evolucionado desde una versión en memoria hacia una aplicación de escritorio completa con persistencia en **MySQL** e interfaz gráfica **Java Swing**.

---

## 📂 Estructura del proyecto

A continuación se detalla la organización del código fuente en `src/main/java`:

```text
src
 ├── main
 │   └── java
 │       ├── application             -> (Capa de Aplicación) Casos de uso, DTOs y Mappers
 │       │    ├── dto
 │       │    │   ├── contratos
 │       │    │   └── emisoras
 │       │    ├── mappers            -> Conversión entre DTOs y Entidades de Dominio
 │       │    └── usecases           -> Orquestación de lógica (Puertos de entrada)
 │       │        ├── contratos
 │       │        ├── emisoras
 │       │        └── reportes       -> Casos de uso para consultas complejas
 │       │
 │       ├── domain                  -> (Capa de Dominio) Reglas de negocio puras
 │       │    ├── contratos          -> Agregados (Contrato, Patrocinador, Duracion)
 │       │    ├── emisoras           -> Entidades (Emisora, Programa, FranjaHoraria)
 │       │    ├── eventos            -> Eventos de dominio
 │       │    ├── excepciones        -> Excepciones de negocio (ContratoVencidoException)
 │       │    ├── servicios          -> Servicios de dominio (Cálculo de tarifas)
 │       │    └── specification      -> Patrón Specification (Validación de reglas)
 │       │
 │       └── infrastructure          -> (Capa de Infraestructura) Adaptadores
 │            ├── adapters
 │            │   ├── database       -> Configuración de conexión JDBC (Singleton)
 │            │   ├── in             -> Adaptadores de Entrada (UI y Servicios)
 │            │   │   ├── contratos  -> Servicios intermedios
 │            │   │   ├── emisoras
 │            │   │   └── ui         -> Interfaz Gráfica (Swing: Paneles y Ventanas)
 │            │   └── out            -> Adaptadores de Salida (Persistencia)
 │            │       ├── contratos  -> Impl. MySQL e InMemory
 │            │       ├── emisoras   -> Impl. MySQL e InMemory
 │            │       └── reportes   -> Repositorios de consultas SQL avanzadas
 │
 └── test                            -> Pruebas Unitarias
     └── java
         ├── application
         └── domain
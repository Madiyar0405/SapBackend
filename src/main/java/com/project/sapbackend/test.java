//import jakarta.persistence.OneToOne;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.Set;
//
//// Роли
//@Entity
//@Table(name = "roles")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
//    private Long roleId;
//
//    @Column(name = "role_name", nullable = false)
//    private String roleName;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// CRUD права
//@Entity
//@Table(name = "crud_permissions")
//public class CrudPermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "permission_id")
//    private Long permissionId;
//
//    @Column(name = "permission_name", nullable = false)
//    private String permissionName;
//
//    @Column(name = "description")
//    private String description;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// RACI права
//@Entity
//@Table(name = "raci_permissions")
//public class RaciPermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "permission_id")
//    private Long permissionId;
//
//    @Column(name = "permission_name", nullable = false)
//    private String permissionName;
//
//    @Column(name = "description")
//    private String description;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Привязка ролей к CRUD правам
//@Entity
//@Table(name = "role_crud_permissions")
//public class RoleCrudPermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//
//    @ManyToOne
//    @JoinColumn(name = "permission_id")
//    private CrudPermission crudPermission;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Привязка ролей к RACI правам
//@Entity
//@Table(name = "role_raci_permissions")
//public class RoleRaciPermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private Role role;
//
//    @ManyToOne
//    @JoinColumn(name = "permission_id")
//    private RaciPermission raciPermission;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Каталог ИТ-услуг
//@Entity
//@Table(name = "it_service_catalog")
//public class ITServiceCatalog {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "service_id")
//    private Long serviceId;
//
//    @Column(name = "service_name", nullable = false)
//    private String serviceName;
//
//    @OneToMany(mappedBy = "itServiceCatalog", cascade = CascadeType.ALL)
//    private Set<RequestType> requestTypes;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Типы запросов
//@Entity
//@Table(name = "request_types")
//public class RequestType {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "type_id")
//    private Long typeId;
//
//    @ManyToOne
//    @JoinColumn(name = "service_id", nullable = false)
//    private ITServiceCatalog itServiceCatalog;
//
//    @Column(name = "type_name", nullable = false)
//    private String typeName;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Местоположения
//@Entity
//@Table(name = "locations")
//public class Location {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "location_id")
//    private Long locationId;
//
//    @Column(name = "address", nullable = false)
//    private String address;
//
//    @Column(name = "region", nullable = false)
//    private String region;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Административные объекты
//@Entity
//@Table(name = "administrative_objects")
//public class AdministrativeObject {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "object_id")
//    private Long objectId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "location_id")
//    private Location location;
//
//    @OneToMany(mappedBy = "administrativeObject", cascade = CascadeType.ALL)
//    private Set<ProductionObject> productionObjects;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Производственные объекты
//@Entity
//@Table(name = "production_objects")
//public class ProductionObject {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "production_object_id")
//    private Long productionObjectId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "admin_object_id")
//    private AdministrativeObject administrativeObject;
//
//    @OneToMany(mappedBy = "productionObject", cascade = CascadeType.ALL)
//    private Set<Horizon> horizons;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Горизонты
//@Entity
//@Table(name = "horizons")
//public class Horizon {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "horizon_id")
//    private Long horizonId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "production_object_id")
//    private ProductionObject productionObject;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Типы линий ВОЛС
//@Entity
//@Table(name = "optical_fiber_line_types")
//public class OpticalFiberLineType {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Линии ВОЛС
//@Entity
//@Table(name = "optical_fiber_lines")
//public class OpticalFiberLine {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "administrative_object_id")
//    private AdministrativeObject administrativeObject;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Сотрудники
//@Entity
//@Table(name = "employees")
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "employee_id")
//    private Long employeeId;
//
//    @Column(name = "full_name", nullable = false)
//    private String fullName;
//
//    @Column(name = "department", nullable = false)
//    private String department;
//
//    @Column(name = "position", nullable = false)
//    private String position;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Причины инцидентов ВОЛС
//@Entity
//@Table(name = "incident_causes")
//public class IncidentCause {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cause_id")
//    private Long causeId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Принятые меры
//@Entity
//@Table(name = "accepted_measures")
//public class AcceptedMeasure {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "measure_id")
//    private Long measureId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Причины продления запросов
//@Entity
//@Table(name = "request_extension_causes")
//public class RequestExtensionCause {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cause_id")
//    private Long causeId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Статус инцидента
//@Entity
//@Table(name = "incident_status")
//public class IncidentStatus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "status_id")
//    private Long statusId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "note")
//    private String note;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Статус запроса
//@Entity
//@Table(name = "request_status")
//public class RequestStatus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "status_id")
//    private Long statusId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Группы поддержки
//@Entity
//@Table(name = "support_group")
//public class SupportGroup {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "group_id")
//    private Long groupId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Справочник
//@Entity
//@Table(name = "reference_list")
//public class ReferenceList {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "reference_id")
//    private Long referenceId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Способы прокладки
//@Entity
//@Table(name = "laying_methods")
//public class LayingMethod {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "method_id")
//    private Long methodId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Марки кабеля
//@Entity
//@Table(name = "cable_brands")
//public class CableBrand {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cable_id")
//    private Long cableId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "cable_type", nullable = false)
//    private String cableType;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//@Entity
//@Table(name = "it_assets")
//public class ITAsset {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "category")
//    private String category;
//
//    @Column(name = "subcategory_ru")
//    private String subcategoryRu;
//
//    @Column(name = "subcategory_en")
//    private String subcategoryEn;
//
//    @Column(name = "asset_group_name_ru")
//    private String assetGroupNameRu;
//
//    @Column(name = "asset_group_name_en")
//    private String assetGroupNameEn;
//
//    @Column(name = "asset_subgroup_name_ru")
//    private String assetSubgroupNameRu;
//
//    @Column(name = "asset_subgroup_name_en")
//    private String assetSubgroupNameEn;
//
//    @Column(name = "asset_type_name_ru")
//    private String assetTypeNameRu;
//
//    @Column(name = "asset_type_name_en")
//    private String assetTypeNameEn;
//
//    @Column(name = "asset_brand_name_ru")
//    private String assetBrandNameRu;
//
//    @Column(name = "asset_brand_name_en")
//    private String assetBrandNameEn;
//
//    @Column(name = "spare_part_name_ru")
//    private String sparePartNameRu;
//
//    @Column(name = "spare_part_name_en")
//    private String sparePartNameEn;
//
//    @Column(name = "usage", columnDefinition = "TEXT")
//    private String usage;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//@Entity
//@Table(name = "incident_request_causes")
//public class IncidentRequestCause {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "request_id")
//    private IncidentRequest incidentRequest;
//
//    @ManyToOne
//    @JoinColumn(name = "cause_id")
//    private IncidentCause incidentCause;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Обработка запросов
//@Entity
//@Table(name = "request_processing")
//public class RequestProcessing {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "request_id")
//    private Long requestId;
//
//    @Column(name = "material_costs")
//    private Double materialCosts;
//
//    @Column(name = "solution", columnDefinition = "TEXT")
//    private String solution;
//
//    @Column(name = "comment", columnDefinition = "TEXT")
//    private String comment;
//
//    @ManyToOne
//    @JoinColumn(name = "incident_status_id")
//    private IncidentStatus incidentStatus;
//
//    @ManyToOne
//    @JoinColumn(name = "request_status_id")
//    private RequestStatus requestStatus;
//
//    @Column(name = "closing_datetime")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date closingDatetime;
//
//    @OneToMany(mappedBy = "requestProcessing", cascade = CascadeType.ALL)
//    private Set<RequestAcceptedMeasure> requestAcceptedMeasures;
//
//    @OneToMany(mappedBy = "requestProcessing", cascade = CascadeType.ALL)
//    private Set<RequestExecutor> requestExecutors;
//
//    @OneToMany(mappedBy = "requestProcessing", cascade = CascadeType.ALL)
//    private Set<RequestExtensionCausesJunction> requestExtensionCausesJunctions;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Принятые меры по запросу
//@Entity
//@Table(name = "request_accepted_measures")
//public class RequestAcceptedMeasure {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "request_id")
//    private RequestProcessing requestProcessing;
//
//    @ManyToOne
//    @JoinColumn(name = "measure_id")
//    private AcceptedMeasure acceptedMeasure;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Исполнители запроса
//@Entity
//@Table(name = "request_executors")
//public class RequestExecutor {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "request_id")
//    private RequestProcessing requestProcessing;
//
//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
//
//// Причины продления запросов (связь)
//@Entity
//@Table(name = "request_extension_causes_junction")
//public class RequestExtensionCausesJunction {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "request_id")
//    private RequestProcessing requestProcessing;
//
//    @ManyToOne
//    @JoinColumn(name = "cause_id")
//    private RequestExtensionCause requestExtensionCause;
//
//    // Геттеры и сеттеры
//
//    // ...
//}
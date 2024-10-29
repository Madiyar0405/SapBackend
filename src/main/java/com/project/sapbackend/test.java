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
//// Типы запросов

//
//// Местоположения
//
//// Административные объекты
//
//// Производственные объекты//
//// Горизонты

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

//
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
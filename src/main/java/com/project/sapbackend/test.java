//import javax.persistence.*;
//import java.sql.Timestamp;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Table(name = "roles")
//public class Role {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "role_id")
//    private Integer roleId;
//
//    @Column(name = "role_name", nullable = false)
//    private String roleName;
//
//    @ManyToMany
//    @JoinTable(
//            name = "role_crud_permissions",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "permission_id")
//    )
//    private Set<CrudPermission> crudPermissions;
//
//    @ManyToMany
//    @JoinTable(
//            name = "role_raci_permissions",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "permission_id")
//    )
//    private Set<RaciPermission> raciPermissions;
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "crud_permissions")
//public class CrudPermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "permission_id")
//    private Integer permissionId;
//
//    @Column(name = "permission_name", nullable = false)
//    private String permissionName;
//
//    @Column(name = "description")
//    private String description;
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "raci_permissions")
//public class RaciPermission {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "permission_id")
//    private Integer permissionId;
//
//    @Column(name = "permission_name", nullable = false)
//    private String permissionName;
//
//    @Column(name = "description")
//    private String description;
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "it_service_catalog")
//public class ITServiceCatalog {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "service_id")
//    private Integer serviceId;
//
//    @Column(name = "service_name", nullable = false)
//    private String serviceName;
//
//    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
//    private List<RequestType> requestTypes;
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "request_types")
//public class RequestType {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "type_id")
//    private Integer typeId;
//
//    @ManyToOne
//    @JoinColumn(name = "service_id")
//    private ITServiceCatalog service;
//
//    @Column(name = "type_name", nullable = false)
//    private String typeName;
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "locations")
//public class Location {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "location_id")
//    private Integer locationId;
//
//    @Column(name = "address", nullable = false)
//    private String address;
//
//    @Column(name = "region", nullable = false)
//    private String region;
//
//
//    //Getters and setters
//
//}
//
//
//
//@Entity
//@Table(name = "administrative_objects")
//public class AdministrativeObject {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "object_id")
//    private Integer objectId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    @ManyToOne
//    @JoinColumn(name = "location_id")
//    private Location location;
//
//
//    @OneToMany(mappedBy = "administrativeObject", cascade = CascadeType.ALL)
//    private List<ProductionObject> productionObjects;
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "production_objects")
//public class ProductionObject {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "production_object_id")
//    private Integer productionObjectId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "admin_object_id")
//    private AdministrativeObject administrativeObject;
//
//
//    @OneToMany(mappedBy = "productionObject", cascade = CascadeType.ALL)
//    private List<Horizon> horizons;
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "horizons")
//public class Horizon {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "horizon_id")
//    private Integer horizonId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    @ManyToOne
//    @JoinColumn(name = "production_object_id")
//    private ProductionObject productionObject;
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "optical_fiber_line_types")
//public class OpticalFiberLineType {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "optical_fiber_lines")
//public class OpticalFiberLine {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToOne
//    @JoinColumn(name = "administrative_object_id")
//    private  AdministrativeObject administrativeObject;
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "employees")
//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "employee_id")
//    private Integer employeeId;
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
//    @ManyToMany(mappedBy = "executors")
//    private List<RequestProcessing> requestProcessings;
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "incident_causes")
//public class IncidentCause {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cause_id")
//    private Integer causeId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    @ManyToMany(mappedBy = "incidentCauses")
//    private List<IncidentRequest> incidentRequests;
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "accepted_measures")
//public class AcceptedMeasure {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "measure_id")
//    private Integer measureId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @ManyToMany(mappedBy = "acceptedMeasures")
//    private List<RequestProcessing> requestProcessings;
//
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "request_extension_causes")
//public class RequestExtensionCause {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cause_id")
//    private Integer causeId;
//
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    @ManyToMany(mappedBy = "requestExtensionCauses")
//    private List<RequestProcessing> requestProcessings;
//    // Getters and setters
//}
//
//@Entity
//@Table(name = "incident_status")
//public class IncidentStatus {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "status_id")
//    private Integer statusId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "note")
//    private String note;
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "request_status")
//public class RequestStatus {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "status_id")
//    private Integer statusId;
//
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "support_group")
//public class SupportGroup {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "group_id")
//    private Integer groupId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "reference_list")
//public class ReferenceList {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "reference_id")
//    private Integer referenceId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    // Getters and setters
//}
//
//
//@Entity
//@Table(name = "laying_methods")
//public class LayingMethod {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "method_id")
//    private Integer methodId;
//
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "cable_brands")
//public class CableBrand {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cable_id")
//    private Integer cableId;
//
//    @Column(name = "name", nullable = false)
//    private String name;
//
//    @Column(name = "cable_type", nullable = false)
//    private String cableType;
//
//
//
//    // Getters and setters
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
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "category")
//    private String category;
//
//
//    @Column(name = "subcategory_ru")
//    private String subcategoryRu;
//
//
//    @Column(name = "subcategory_en")
//    private String subcategoryEn;
//
//
//    @Column(name = "asset_group_name_ru")
//    private String assetGroupNameRu;
//
//    @Column(name = "asset_group_name_en")
//    private String assetGroupNameEn;
//
//
//    @Column(name = "asset_subgroup_name_ru")
//    private String assetSubgroupNameRu;
//
//
//    @Column(name = "asset_subgroup_name_en")
//    private String assetSubgroupNameEn;
//
//
//
//    @Column(name = "asset_type_name_ru")
//    private String assetTypeNameRu;
//
//
//    @Column(name = "asset_type_name_en")
//    private String assetTypeNameEn;
//
//
//    @Column(name = "asset_brand_name_ru")
//    private String assetBrandNameRu;
//
//
//    @Column(name = "asset_brand_name_en")
//    private String assetBrandNameEn;
//
//
//
//    @Column(name = "spare_part_name_ru")
//    private String sparePartNameRu;
//
//
//    @Column(name = "spare_part_name_en")
//    private String sparePartNameEn;
//
//
//    @Column(name = "usage")
//    private String usage;
//
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "incident_requests")
//public class IncidentRequest {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "request_id")
//    private Integer requestId;
//
//
//
//    @Column(name = "registration_datetime")
//    private Timestamp registrationDatetime;
//
//    @ManyToOne
//    @JoinColumn(name = "service_id")
//    private ITServiceCatalog service;
//
//
//    @ManyToOne
//    @JoinColumn(name = "request_type_id")
//    private RequestType requestType;
//
//    @Column(name = "initiator_name", nullable = false)
//    private String initiatorName;
//
//    @ManyToOne
//    @JoinColumn(name = "incident_location_id")
//    private Location incidentLocation;
//
//
//    @Column(name = "additional_info")
//    private String additionalInfo;
//
//    @ManyToOne
//    @JoinColumn(name = "support_group_id")
//    private SupportGroup supportGroup;
//
//
//    @Column(name = "redirect_count")
//    private Integer redirectCount;
//
//    @Column(name = "incident_description", nullable = false)
//    private String incidentDescription;
//
//    @ManyToOne
//    @JoinColumn(name = "admin_object_id")
//    private AdministrativeObject adminObject;
//
//    @ManyToOne
//    @JoinColumn(name = "production_object_id")
//    private ProductionObject productionObject;
//
//    @ManyToOne
//    @JoinColumn(name = "fiber_name_id")
//    private OpticalFiberLine fiberName;
//
//
//    @ManyToOne
//    @JoinColumn(name = "line_type_id")
//    private OpticalFiberLineType lineType;
//
//
//    @ManyToOne
//    @JoinColumn(name = "horizon_id")
//    private Horizon horizon;
//
//
//
//    @ManyToOne
//    @JoinColumn(name = "fiber_brand_id")
//    private CableBrand fiberBrand;
//
//
//    @Column(name = "total_fibers")
//    private Integer totalFibers;
//
//
//
//    @Column(name = "cable_length")
//    private Double cableLength;
//
//
//
//    @ManyToOne
//    @JoinColumn(name = "laying_method_id")
//    private LayingMethod layingMethod;
//
//
//    @Column(name = "incident_photo")
//    private byte[] incidentPhoto;
//
//    @ManyToMany
//    @JoinTable(name = "incident_request_causes",
//            joinColumns = @JoinColumn(name = "request_id"),
//            inverseJoinColumns = @JoinColumn(name = "cause_id"))
//    private List<IncidentCause> incidentCauses;
//
//    // Getters and setters
//}
//
//
//
//@Entity
//@Table(name = "request_processing")
//public class RequestProcessing {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "request_id")
//    private Integer requestId;
//
//    @Column(name = "material_costs")
//    private Double materialCosts;
//
//    @Column(name = "solution")
//    private String solution;
//
//    @Column(name = "comment")
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
//
//    @Column(name = "closing_datetime")
//    private Timestamp closingDatetime;
//
//    @ManyToMany
//    @JoinTable(name = "request_accepted_measures",
//            joinColumns = @JoinColumn(name = "request_id"),
//            inverseJoinColumns = @JoinColumn(name = "measure_id"))
//    private List<AcceptedMeasure> acceptedMeasures;
//
//    @ManyToMany
//    @JoinTable(name = "request_executors",
//            joinColumns = @JoinColumn(name = "request_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id"))
//    private List<Employee> executors;
//
//
//    @ManyToMany
//    @JoinTable(name = "request_extension_causes_junction",
//            joinColumns = @JoinColumn(name = "request_id"),
//            inverseJoinColumns = @JoinColumn(name = "cause_id"))
//    private List<RequestExtensionCause> requestExtensionCauses;
//
//    // ... getters and setters
//
//}
//
//
//@Entity
//@Table(name = "incidents") // Ensure this table name is correct in your database
//public class Incident {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//
//    @Column(name = "registration_time", nullable = false)
//    private Timestamp registrationTime;
//
//    @Column(nullable = false)
//    private String service;
//
//    @Column(name = "request_type", nullable = false)
//    private String requestType;
//
//    @Column(nullable = false)
//    private String initiator;
//
//    @Column(nullable = false)
//    private String location;
//
//    @Column(name = "floor_office")
//    private String floorOffice;
//
//    @Column(name = "support_group", nullable = false)
//    private Integer supportGroup;
//
//    @Column(name = "redirect_count", nullable = false)
//    private Integer redirectCount;
//
//    @Column(name = "short_description", nullable = false, columnDefinition = "TEXT")
//    private String shortDescription;
//
//
//    @Column(name = "administrative_object", nullable = false)
//    private String administrativeObject;
//
//    @Column(name = "production_object", nullable = false)
//    private String productionObject;
//
//
//    @Column(name = "name_of_fiber_optic_line", nullable = false)
//    private String nameOfFiberOpticLine;
//
//
//    @Column(name = "line_type", nullable = false)
//    private String lineType;
//
//
//
//    @Column(nullable = false)
//    private String horizontal;
//
//    @Column(name = "fiber_optic_cable_brand", nullable = false)
//    private String fiberOpticCableBrand;
//
//
//    @Column(name = "total_number_of_cores", nullable = false)
//    private Integer totalNumberOfCores;
//
//
//    @Column(name = "cable_length_m", nullable = false)
//    private Double cableLengthM;
//
//
//    @Column(name = "cable_laying_method", nullable = false)
//    private String cableLayingMethod;
//
//
//    @Column(name = "incident_reason", nullable = false)
//    private String incidentReason;
//
//
//    @Column(name = "incident_photo")
//    private String incidentPhoto;
//
//
//    @Column(name = "measures_taken")
//    private String measuresTaken;
//
//
//
//
//    @Column(name = "material_costs_cable_m")
//    private Double materialCostsCableM;
//
//
//    @Column(name = "request_executor", nullable = false)
//    private String requestExecutor;
//
//    @Column(name = "incident_status", nullable = false)
//    private String incidentStatus;
//
//    @Column(name = "decision")
//    private String decision;
//
//
//
//    @Column(name = "reasons_for_request_extension")
//    private String reasonsForRequestExtension;
//
//
//    @Column(name = "request_status", nullable = false)
//    private String requestStatus;
//
//
//
//    @Column(name = "closure_datetime")
//    private Timestamp closureDatetime;
//
//    // Getters and setters
//}
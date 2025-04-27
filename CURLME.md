
# Test Scenarios for Phone Filtering API

## Scenario 1: Filtering phones by brand, simType, network, and operatingSystem
This test filters phones where the brand is "Apple", the network is "5G", and the operating system is "iOS". `simType` is ignored since it is null.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": "Apple",
        "simType": null,
        "network": "5G",
        "deal": null,
        "operatingSystem": "iOS"
    }'
```

### Expected Response:
The response should return all phones with brand "Apple", network "5G", and operating system "iOS". `simType` is ignored, so any sim type is allowed.

---

## Scenario 2: Filtering phones by brand and simType only
This test filters phones by brand "Apple" and simType "eSIM" while ignoring other attributes (network, deal, and operatingSystem).

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": "Apple",
        "simType": "eSIM",
        "network": null,
        "deal": null,
        "operatingSystem": null
    }'
```

### Expected Response:
The response should return all phones with brand "Apple" and simType "eSIM", ignoring network, deal, and operating system attributes.

---

## Scenario 3: Filtering phones by multiple criteria with null values
This test filters phones by brand "Apple", network "5G", and operating system "iOS". `deal` and `simType` are null and should be ignored.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": "Apple",
        "simType": null,
        "network": "5G",
        "deal": null,
        "operatingSystem": "iOS"
    }'
```

### Expected Response:
The response should return phones with brand "Apple", network "5G", and operating system "iOS", with `simType` and `deal` being ignored in the filtering process.

---

## Scenario 4: Filtering phones with missing attributes
This test filters phones where some of the attributes are null (`deal` and `simType`), and only the specified attributes should be considered.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": "Apple",
        "simType": null,
        "network": "5G",
        "deal": null,
        "operatingSystem": "iOS"
    }'
```

### Expected Response:
Phones matching the criteria (brand = Apple, network = 5G, operatingSystem = iOS) should be returned. The filtering ignores `simType` and `deal`.

---

## Scenario 5: Filtering phones with multiple null attributes
This scenario filters phones with only a brand ("Apple") specified and all other attributes are null.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": "Apple",
        "simType": null,
        "network": null,
        "deal": null,
        "operatingSystem": null
    }'
```

### Expected Response:
The response should return all phones with brand "Apple", regardless of the other attributes.

---

## Scenario 6: Filtering phones with no filters applied
This test checks the case where no filters are applied (all attributes are null). It should return all phones.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": null,
        "simType": null,
        "network": null,
        "deal": null,
        "operatingSystem": null
    }'
```

### Expected Response:
The response should return all phones in the database, as no filtering criteria are applied.

---

## Scenario 7: Filtering phones with a specific deal
This test filters phones with a specific deal type, "5G Trade". Other attributes are ignored.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": null,
        "simType": null,
        "network": null,
        "deal": "5G Trade",
        "operatingSystem": null
    }'
```

### Expected Response:
The response should return all phones with the deal "5G Trade", regardless of the other attributes.

---

## Scenario 8: Filtering phones with excluded attributes
This test filters phones by "Apple" and ignores network, deal, and operating system.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": "Apple",
        "simType": null,
        "network": null,
        "deal": null,
        "operatingSystem": null
    }'
```

### Expected Response:
The response should return all phones with the brand "Apple", ignoring the values for other attributes.

---

## Scenario 9: Filtering phones with specific network and OS
This test filters phones with network "5G" and operating system "Android", while ignoring other attributes.

### Request:
```bash
curl -X POST http://localhost:8080/api/phones/filter   -H "Content-Type: application/json"   -d '{
        "brand": null,
        "simType": null,
        "network": "5G",
        "deal": null,
        "operatingSystem": "Android"
    }'
```

### Expected Response:
The response should return all phones with network "5G" and operating system "Android", regardless of other attributes.

---

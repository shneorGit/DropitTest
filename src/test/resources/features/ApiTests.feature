@ApiTests
  Feature: Api Tests

    @CreateNewPet
    Scenario: Create new pet
      Given create new pet
      Then update the status to sold

    @FindPetByStatus
    Scenario: Find a pet by status
      Given get all available pets
      And verify the fourth pet name
      Then writer to console the pet object

    @FindAllSoldPets
    Scenario: Find all sold pets
      Given get all sold pets
      Then verify all pets with status sold


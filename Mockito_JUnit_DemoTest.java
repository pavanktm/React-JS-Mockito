public class Mockito_JUnit_DemoTest{

	private static DALObject mockObject;
	private static ModelObject modelObj1;
	private static ModelObject modelObj2;
	
	/*
		public class CustomerService {
			@Inject
			private CustomerDao customerDao;
			public boolean addCustomer(Customer customer){
				if(customerDao.exists(customer.getPhone())){
					 return false;
				}
					 return customerDao.save(customer);
			}
			public CustomerDao getCustomerDao() {
				 return customerDao;
			}
			public void setCustomerDao(CustomerDao customerDao) {
				 this.customerDao = customerDao;
			}
		}

		public class CustomerServiceTest {
			@Mock
			private CustomerDao daoMock;
			@InjectMocks
			private CustomerService service;
			@Before
			public void setUp() throws Exception {
				 MockitoAnnotations.initMocks(this);
			}
			@Test
			public void test() {
				 //assertion here
			}
		}
		
		@Mock will create a mock implementation for the CustomerDao
		@InjectMocks will inject the mocks marked with @Mock to this instance when it is created.
		So when or where are these instances created? Well, it is done in this line, which resides in the setUp method:
		MockitoAnnotations.initMocks(this);
		So these instances would be created at the start of every test method of this test class.
		
		@Test
        public void testAddCustomer_returnsNewCustomer() {
            when(daoMock.save(any(Customer.class))).thenReturn(new Customer());
            Customer customer = new Customer();
            assertThat(service.addCustomer(customer), is(notNullValue()));
        }
	*/
	
	@BeforeClass
	public static void setUp(){
		mockObject = mock(DALObject.class);
		modelObj1 = new ModelObject("a", "b");
		modelObj2 = new ModelObject("c", "d");
		
		when(mockObject.getAllModels()).thenReturn(Arrays.asList(modelObj1, modelObj2));
		when(mockObject.insertModel(modelObj1)).thenReturn(modelObj1.getId());
		when(mockObject.updateModel(modelObj1)).thenReturn(modelObj1.getId());
		when(mockObject.getModelById("a")).thenReturn(modelObj1);
		when(mockObject.getModelById("c")).thenReturn(modelObj1);
		
		//MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void getAllModelsTest throws Exception{
	
		List<ModelObject> models = mockObject.getAllModels();
		assertEquals(2, models.getSize());
		ModelObject model1 = models.get(0);
		ModelObject model2 = models.get(1);
		assertEquals(model1.getId(), modelObj1.getId());
		assertEquals(model2.getId(), modelObj2.getId());
	}
	
	@Test
	public void getModelByIdTest throws Exception{
	
		ModelObject model1 = mockObject.getModelById("a");
		ModelObject model2 = mockObject.getModelById("c");
		assertEquals(model1.getId(), modelObj1.getId());
		assertEquals(model2.getId(), modelObj2.getId());
	}

}
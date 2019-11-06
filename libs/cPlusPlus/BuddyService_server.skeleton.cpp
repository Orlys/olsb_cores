// This autogenerated skeleton file illustrates how to build a server.
// You should copy it to another filename to avoid overwriting it.

#include "BuddyService.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

class BuddyServiceHandler : virtual public BuddyServiceIf {
 public:
  BuddyServiceHandler() {
    // Your initialization goes here
  }

  void findBuddyContactsByQuery(std::vector<BuddySearchResult> & _return, const std::string& language, const std::string& country, const std::string& query, const int32_t fromIndex, const int32_t count, const BuddySearchRequestSource::type requestSource) {
    // Your implementation goes here
    printf("findBuddyContactsByQuery\n");
  }

  void getBuddyContacts(std::vector<Contact> & _return, const std::string& language, const std::string& country, const std::string& classification, const int32_t fromIndex, const int32_t count) {
    // Your implementation goes here
    printf("getBuddyContacts\n");
  }

  void getBuddyDetail(BuddyDetail& _return, const std::string& buddyMid) {
    // Your implementation goes here
    printf("getBuddyDetail\n");
  }

  void getBuddyOnAir(BuddyOnAir& _return, const std::string& buddyMid) {
    // Your implementation goes here
    printf("getBuddyOnAir\n");
  }

  void getCountriesHavingBuddy(std::vector<std::string> & _return) {
    // Your implementation goes here
    printf("getCountriesHavingBuddy\n");
  }

  void getNewlyReleasedBuddyIds(std::map<std::string, int64_t> & _return, const std::string& country) {
    // Your implementation goes here
    printf("getNewlyReleasedBuddyIds\n");
  }

  void getPopularBuddyBanner(BuddyBanner& _return, const std::string& language, const std::string& country, const ApplicationType::type applicationType, const std::string& resourceSpecification) {
    // Your implementation goes here
    printf("getPopularBuddyBanner\n");
  }

  void getPopularBuddyLists(std::vector<BuddyList> & _return, const std::string& language, const std::string& country) {
    // Your implementation goes here
    printf("getPopularBuddyLists\n");
  }

  void getPromotedBuddyContacts(std::vector<Contact> & _return, const std::string& language, const std::string& country) {
    // Your implementation goes here
    printf("getPromotedBuddyContacts\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  ::std::shared_ptr<BuddyServiceHandler> handler(new BuddyServiceHandler());
  ::std::shared_ptr<TProcessor> processor(new BuddyServiceProcessor(handler));
  ::std::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  ::std::shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  ::std::shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}

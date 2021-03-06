// Autogenerated by Thrift Compiler (0.14.0)
// DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING

package main

import (
	"context"
	"flag"
	"fmt"
	"math"
	"net"
	"net/url"
	"os"
	"strconv"
	"strings"
	"github.com/apache/thrift/lib/go/thrift"
	"line"
)

var _ = line.GoUnusedProtection__

func Usage() {
  fmt.Fprintln(os.Stderr, "Usage of ", os.Args[0], " [-h host:port] [-u url] [-f[ramed]] function [arg1 [arg2...]]:")
  flag.PrintDefaults()
  fmt.Fprintln(os.Stderr, "\nFunctions:")
  fmt.Fprintln(os.Stderr, "  void buyCoinProduct(PaymentReservation paymentReservation)")
  fmt.Fprintln(os.Stderr, "  void buyFreeProduct(string receiverMid, string productId, i32 messageTemplate, string language, string country, i64 packageId)")
  fmt.Fprintln(os.Stderr, "  void buyMustbuyProduct(string receiverMid, string productId, i32 messageTemplate, string language, string country, i64 packageId, string serialNumber)")
  fmt.Fprintln(os.Stderr, "  void checkCanReceivePresent(string recipientMid, i64 packageId, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getActivePurchases(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductSimpleList getActivePurchaseVersions(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "   getCoinProducts(PaymentType appStoreCode, string country, string language)")
  fmt.Fprintln(os.Stderr, "   getCoinProductsByPgCode(PaymentType appStoreCode, PaymentPgType pgCode, string country, string language)")
  fmt.Fprintln(os.Stderr, "  CoinHistoryResult getCoinPurchaseHistory(CoinHistoryCondition request)")
  fmt.Fprintln(os.Stderr, "  CoinHistoryResult getCoinUseAndRefundHistory(CoinHistoryCondition request)")
  fmt.Fprintln(os.Stderr, "  ProductList getDownloads(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getEventPackages(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getNewlyReleasedPackages(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getPopularPackages(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getPresentsReceived(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getPresentsSent(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  Product getProduct(i64 packageID, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getProductList( productIdList, string language, string country)")
  fmt.Fprintln(os.Stderr, "  ProductList getProductListWithCarrier( productIdList, string language, string country, string carrierCode)")
  fmt.Fprintln(os.Stderr, "  Product getProductWithCarrier(i64 packageID, string language, string country, string carrierCode)")
  fmt.Fprintln(os.Stderr, "  ProductList getPurchaseHistory(i64 start, i32 size, string language, string country)")
  fmt.Fprintln(os.Stderr, "  Coin getTotalBalance(PaymentType appStoreCode)")
  fmt.Fprintln(os.Stderr, "  i64 notifyDownloaded(i64 packageId, string language)")
  fmt.Fprintln(os.Stderr, "  PaymentReservationResult reserveCoinPurchase(CoinPurchaseReservation request)")
  fmt.Fprintln(os.Stderr, "  PaymentReservationResult reservePayment(PaymentReservation paymentReservation)")
  fmt.Fprintln(os.Stderr)
  os.Exit(0)
}

type httpHeaders map[string]string

func (h httpHeaders) String() string {
  var m map[string]string = h
  return fmt.Sprintf("%s", m)
}

func (h httpHeaders) Set(value string) error {
  parts := strings.Split(value, ": ")
  if len(parts) != 2 {
    return fmt.Errorf("header should be of format 'Key: Value'")
  }
  h[parts[0]] = parts[1]
  return nil
}

func main() {
  flag.Usage = Usage
  var host string
  var port int
  var protocol string
  var urlString string
  var framed bool
  var useHttp bool
  headers := make(httpHeaders)
  var parsedUrl *url.URL
  var trans thrift.TTransport
  _ = strconv.Atoi
  _ = math.Abs
  flag.Usage = Usage
  flag.StringVar(&host, "h", "localhost", "Specify host and port")
  flag.IntVar(&port, "p", 9090, "Specify port")
  flag.StringVar(&protocol, "P", "binary", "Specify the protocol (binary, compact, simplejson, json)")
  flag.StringVar(&urlString, "u", "", "Specify the url")
  flag.BoolVar(&framed, "framed", false, "Use framed transport")
  flag.BoolVar(&useHttp, "http", false, "Use http")
  flag.Var(headers, "H", "Headers to set on the http(s) request (e.g. -H \"Key: Value\")")
  flag.Parse()
  
  if len(urlString) > 0 {
    var err error
    parsedUrl, err = url.Parse(urlString)
    if err != nil {
      fmt.Fprintln(os.Stderr, "Error parsing URL: ", err)
      flag.Usage()
    }
    host = parsedUrl.Host
    useHttp = len(parsedUrl.Scheme) <= 0 || parsedUrl.Scheme == "http" || parsedUrl.Scheme == "https"
  } else if useHttp {
    _, err := url.Parse(fmt.Sprint("http://", host, ":", port))
    if err != nil {
      fmt.Fprintln(os.Stderr, "Error parsing URL: ", err)
      flag.Usage()
    }
  }
  
  cmd := flag.Arg(0)
  var err error
  if useHttp {
    trans, err = thrift.NewTHttpClient(parsedUrl.String())
    if len(headers) > 0 {
      httptrans := trans.(*thrift.THttpClient)
      for key, value := range headers {
        httptrans.SetHeader(key, value)
      }
    }
  } else {
    portStr := fmt.Sprint(port)
    if strings.Contains(host, ":") {
           host, portStr, err = net.SplitHostPort(host)
           if err != nil {
                   fmt.Fprintln(os.Stderr, "error with host:", err)
                   os.Exit(1)
           }
    }
    trans, err = thrift.NewTSocket(net.JoinHostPort(host, portStr))
    if err != nil {
      fmt.Fprintln(os.Stderr, "error resolving address:", err)
      os.Exit(1)
    }
    if framed {
      trans = thrift.NewTFramedTransport(trans)
    }
  }
  if err != nil {
    fmt.Fprintln(os.Stderr, "Error creating transport", err)
    os.Exit(1)
  }
  defer trans.Close()
  var protocolFactory thrift.TProtocolFactory
  switch protocol {
  case "compact":
    protocolFactory = thrift.NewTCompactProtocolFactory()
    break
  case "simplejson":
    protocolFactory = thrift.NewTSimpleJSONProtocolFactory()
    break
  case "json":
    protocolFactory = thrift.NewTJSONProtocolFactory()
    break
  case "binary", "":
    protocolFactory = thrift.NewTBinaryProtocolFactoryDefault()
    break
  default:
    fmt.Fprintln(os.Stderr, "Invalid protocol specified: ", protocol)
    Usage()
    os.Exit(1)
  }
  iprot := protocolFactory.GetProtocol(trans)
  oprot := protocolFactory.GetProtocol(trans)
  client := line.NewShopServiceClient(thrift.NewTStandardClient(iprot, oprot))
  if err := trans.Open(); err != nil {
    fmt.Fprintln(os.Stderr, "Error opening socket to ", host, ":", port, " ", err)
    os.Exit(1)
  }
  
  switch cmd {
  case "buyCoinProduct":
    if flag.NArg() - 1 != 1 {
      fmt.Fprintln(os.Stderr, "BuyCoinProduct requires 1 args")
      flag.Usage()
    }
    arg812 := flag.Arg(1)
    mbTrans813 := thrift.NewTMemoryBufferLen(len(arg812))
    defer mbTrans813.Close()
    _, err814 := mbTrans813.WriteString(arg812)
    if err814 != nil {
      Usage()
      return
    }
    factory815 := thrift.NewTJSONProtocolFactory()
    jsProt816 := factory815.GetProtocol(mbTrans813)
    argvalue0 := line.NewPaymentReservation()
    err817 := argvalue0.Read(jsProt816)
    if err817 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    fmt.Print(client.BuyCoinProduct(context.Background(), value0))
    fmt.Print("\n")
    break
  case "buyFreeProduct":
    if flag.NArg() - 1 != 6 {
      fmt.Fprintln(os.Stderr, "BuyFreeProduct requires 6 args")
      flag.Usage()
    }
    argvalue0 := flag.Arg(1)
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    tmp2, err820 := (strconv.Atoi(flag.Arg(3)))
    if err820 != nil {
      Usage()
      return
    }
    argvalue2 := int32(tmp2)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    argvalue4 := flag.Arg(5)
    value4 := argvalue4
    argvalue5, err823 := (strconv.ParseInt(flag.Arg(6), 10, 64))
    if err823 != nil {
      Usage()
      return
    }
    value5 := argvalue5
    fmt.Print(client.BuyFreeProduct(context.Background(), value0, value1, value2, value3, value4, value5))
    fmt.Print("\n")
    break
  case "buyMustbuyProduct":
    if flag.NArg() - 1 != 7 {
      fmt.Fprintln(os.Stderr, "BuyMustbuyProduct requires 7 args")
      flag.Usage()
    }
    argvalue0 := flag.Arg(1)
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    tmp2, err826 := (strconv.Atoi(flag.Arg(3)))
    if err826 != nil {
      Usage()
      return
    }
    argvalue2 := int32(tmp2)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    argvalue4 := flag.Arg(5)
    value4 := argvalue4
    argvalue5, err829 := (strconv.ParseInt(flag.Arg(6), 10, 64))
    if err829 != nil {
      Usage()
      return
    }
    value5 := argvalue5
    argvalue6 := flag.Arg(7)
    value6 := argvalue6
    fmt.Print(client.BuyMustbuyProduct(context.Background(), value0, value1, value2, value3, value4, value5, value6))
    fmt.Print("\n")
    break
  case "checkCanReceivePresent":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "CheckCanReceivePresent requires 4 args")
      flag.Usage()
    }
    argvalue0 := flag.Arg(1)
    value0 := argvalue0
    argvalue1, err832 := (strconv.ParseInt(flag.Arg(2), 10, 64))
    if err832 != nil {
      Usage()
      return
    }
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.CheckCanReceivePresent(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getActivePurchases":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetActivePurchases requires 4 args")
      flag.Usage()
    }
    argvalue0, err835 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err835 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err836 := (strconv.Atoi(flag.Arg(2)))
    if err836 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetActivePurchases(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getActivePurchaseVersions":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetActivePurchaseVersions requires 4 args")
      flag.Usage()
    }
    argvalue0, err839 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err839 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err840 := (strconv.Atoi(flag.Arg(2)))
    if err840 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetActivePurchaseVersions(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getCoinProducts":
    if flag.NArg() - 1 != 3 {
      fmt.Fprintln(os.Stderr, "GetCoinProducts requires 3 args")
      flag.Usage()
    }
    tmp0, err := (strconv.Atoi(flag.Arg(1)))
    if err != nil {
      Usage()
     return
    }
    argvalue0 := line.PaymentType(tmp0)
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    fmt.Print(client.GetCoinProducts(context.Background(), value0, value1, value2))
    fmt.Print("\n")
    break
  case "getCoinProductsByPgCode":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetCoinProductsByPgCode requires 4 args")
      flag.Usage()
    }
    tmp0, err := (strconv.Atoi(flag.Arg(1)))
    if err != nil {
      Usage()
     return
    }
    argvalue0 := line.PaymentType(tmp0)
    value0 := argvalue0
    tmp1, err := (strconv.Atoi(flag.Arg(2)))
    if err != nil {
      Usage()
     return
    }
    argvalue1 := line.PaymentPgType(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetCoinProductsByPgCode(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getCoinPurchaseHistory":
    if flag.NArg() - 1 != 1 {
      fmt.Fprintln(os.Stderr, "GetCoinPurchaseHistory requires 1 args")
      flag.Usage()
    }
    arg847 := flag.Arg(1)
    mbTrans848 := thrift.NewTMemoryBufferLen(len(arg847))
    defer mbTrans848.Close()
    _, err849 := mbTrans848.WriteString(arg847)
    if err849 != nil {
      Usage()
      return
    }
    factory850 := thrift.NewTJSONProtocolFactory()
    jsProt851 := factory850.GetProtocol(mbTrans848)
    argvalue0 := line.NewCoinHistoryCondition()
    err852 := argvalue0.Read(jsProt851)
    if err852 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    fmt.Print(client.GetCoinPurchaseHistory(context.Background(), value0))
    fmt.Print("\n")
    break
  case "getCoinUseAndRefundHistory":
    if flag.NArg() - 1 != 1 {
      fmt.Fprintln(os.Stderr, "GetCoinUseAndRefundHistory requires 1 args")
      flag.Usage()
    }
    arg853 := flag.Arg(1)
    mbTrans854 := thrift.NewTMemoryBufferLen(len(arg853))
    defer mbTrans854.Close()
    _, err855 := mbTrans854.WriteString(arg853)
    if err855 != nil {
      Usage()
      return
    }
    factory856 := thrift.NewTJSONProtocolFactory()
    jsProt857 := factory856.GetProtocol(mbTrans854)
    argvalue0 := line.NewCoinHistoryCondition()
    err858 := argvalue0.Read(jsProt857)
    if err858 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    fmt.Print(client.GetCoinUseAndRefundHistory(context.Background(), value0))
    fmt.Print("\n")
    break
  case "getDownloads":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetDownloads requires 4 args")
      flag.Usage()
    }
    argvalue0, err859 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err859 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err860 := (strconv.Atoi(flag.Arg(2)))
    if err860 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetDownloads(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getEventPackages":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetEventPackages requires 4 args")
      flag.Usage()
    }
    argvalue0, err863 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err863 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err864 := (strconv.Atoi(flag.Arg(2)))
    if err864 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetEventPackages(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getNewlyReleasedPackages":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetNewlyReleasedPackages requires 4 args")
      flag.Usage()
    }
    argvalue0, err867 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err867 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err868 := (strconv.Atoi(flag.Arg(2)))
    if err868 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetNewlyReleasedPackages(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getPopularPackages":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetPopularPackages requires 4 args")
      flag.Usage()
    }
    argvalue0, err871 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err871 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err872 := (strconv.Atoi(flag.Arg(2)))
    if err872 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetPopularPackages(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getPresentsReceived":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetPresentsReceived requires 4 args")
      flag.Usage()
    }
    argvalue0, err875 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err875 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err876 := (strconv.Atoi(flag.Arg(2)))
    if err876 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetPresentsReceived(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getPresentsSent":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetPresentsSent requires 4 args")
      flag.Usage()
    }
    argvalue0, err879 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err879 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err880 := (strconv.Atoi(flag.Arg(2)))
    if err880 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetPresentsSent(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getProduct":
    if flag.NArg() - 1 != 3 {
      fmt.Fprintln(os.Stderr, "GetProduct requires 3 args")
      flag.Usage()
    }
    argvalue0, err883 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err883 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    fmt.Print(client.GetProduct(context.Background(), value0, value1, value2))
    fmt.Print("\n")
    break
  case "getProductList":
    if flag.NArg() - 1 != 3 {
      fmt.Fprintln(os.Stderr, "GetProductList requires 3 args")
      flag.Usage()
    }
    arg886 := flag.Arg(1)
    mbTrans887 := thrift.NewTMemoryBufferLen(len(arg886))
    defer mbTrans887.Close()
    _, err888 := mbTrans887.WriteString(arg886)
    if err888 != nil { 
      Usage()
      return
    }
    factory889 := thrift.NewTJSONProtocolFactory()
    jsProt890 := factory889.GetProtocol(mbTrans887)
    containerStruct0 := line.NewShopServiceGetProductListArgs()
    err891 := containerStruct0.ReadField1(jsProt890)
    if err891 != nil {
      Usage()
      return
    }
    argvalue0 := containerStruct0.ProductIdList
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    fmt.Print(client.GetProductList(context.Background(), value0, value1, value2))
    fmt.Print("\n")
    break
  case "getProductListWithCarrier":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetProductListWithCarrier requires 4 args")
      flag.Usage()
    }
    arg894 := flag.Arg(1)
    mbTrans895 := thrift.NewTMemoryBufferLen(len(arg894))
    defer mbTrans895.Close()
    _, err896 := mbTrans895.WriteString(arg894)
    if err896 != nil { 
      Usage()
      return
    }
    factory897 := thrift.NewTJSONProtocolFactory()
    jsProt898 := factory897.GetProtocol(mbTrans895)
    containerStruct0 := line.NewShopServiceGetProductListWithCarrierArgs()
    err899 := containerStruct0.ReadField1(jsProt898)
    if err899 != nil {
      Usage()
      return
    }
    argvalue0 := containerStruct0.ProductIdList
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetProductListWithCarrier(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getProductWithCarrier":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetProductWithCarrier requires 4 args")
      flag.Usage()
    }
    argvalue0, err903 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err903 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetProductWithCarrier(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getPurchaseHistory":
    if flag.NArg() - 1 != 4 {
      fmt.Fprintln(os.Stderr, "GetPurchaseHistory requires 4 args")
      flag.Usage()
    }
    argvalue0, err907 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err907 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    tmp1, err908 := (strconv.Atoi(flag.Arg(2)))
    if err908 != nil {
      Usage()
      return
    }
    argvalue1 := int32(tmp1)
    value1 := argvalue1
    argvalue2 := flag.Arg(3)
    value2 := argvalue2
    argvalue3 := flag.Arg(4)
    value3 := argvalue3
    fmt.Print(client.GetPurchaseHistory(context.Background(), value0, value1, value2, value3))
    fmt.Print("\n")
    break
  case "getTotalBalance":
    if flag.NArg() - 1 != 1 {
      fmt.Fprintln(os.Stderr, "GetTotalBalance requires 1 args")
      flag.Usage()
    }
    tmp0, err := (strconv.Atoi(flag.Arg(1)))
    if err != nil {
      Usage()
     return
    }
    argvalue0 := line.PaymentType(tmp0)
    value0 := argvalue0
    fmt.Print(client.GetTotalBalance(context.Background(), value0))
    fmt.Print("\n")
    break
  case "notifyDownloaded":
    if flag.NArg() - 1 != 2 {
      fmt.Fprintln(os.Stderr, "NotifyDownloaded requires 2 args")
      flag.Usage()
    }
    argvalue0, err911 := (strconv.ParseInt(flag.Arg(1), 10, 64))
    if err911 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    argvalue1 := flag.Arg(2)
    value1 := argvalue1
    fmt.Print(client.NotifyDownloaded(context.Background(), value0, value1))
    fmt.Print("\n")
    break
  case "reserveCoinPurchase":
    if flag.NArg() - 1 != 1 {
      fmt.Fprintln(os.Stderr, "ReserveCoinPurchase requires 1 args")
      flag.Usage()
    }
    arg913 := flag.Arg(1)
    mbTrans914 := thrift.NewTMemoryBufferLen(len(arg913))
    defer mbTrans914.Close()
    _, err915 := mbTrans914.WriteString(arg913)
    if err915 != nil {
      Usage()
      return
    }
    factory916 := thrift.NewTJSONProtocolFactory()
    jsProt917 := factory916.GetProtocol(mbTrans914)
    argvalue0 := line.NewCoinPurchaseReservation()
    err918 := argvalue0.Read(jsProt917)
    if err918 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    fmt.Print(client.ReserveCoinPurchase(context.Background(), value0))
    fmt.Print("\n")
    break
  case "reservePayment":
    if flag.NArg() - 1 != 1 {
      fmt.Fprintln(os.Stderr, "ReservePayment requires 1 args")
      flag.Usage()
    }
    arg919 := flag.Arg(1)
    mbTrans920 := thrift.NewTMemoryBufferLen(len(arg919))
    defer mbTrans920.Close()
    _, err921 := mbTrans920.WriteString(arg919)
    if err921 != nil {
      Usage()
      return
    }
    factory922 := thrift.NewTJSONProtocolFactory()
    jsProt923 := factory922.GetProtocol(mbTrans920)
    argvalue0 := line.NewPaymentReservation()
    err924 := argvalue0.Read(jsProt923)
    if err924 != nil {
      Usage()
      return
    }
    value0 := argvalue0
    fmt.Print(client.ReservePayment(context.Background(), value0))
    fmt.Print("\n")
    break
  case "":
    Usage()
    break
  default:
    fmt.Fprintln(os.Stderr, "Invalid function ", cmd)
  }
}
